package com.jaewon.security.service;

import com.jaewon.security.entity.Customer;
import com.jaewon.security.entity.Role;
import com.jaewon.security.repository.MemberRepository;
import com.jaewon.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final RoleService roleService;

    // 회원가입 동작
    public Customer memberRegister(Customer customer) {
        // 1. 패스워드 암호화
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        //2. 권한부여(USER, MANAGER, ADMIN) : member_roles : USER(1)
        Set<Role> roles = new HashSet<>();
        Role userRole = roleService.findByName("USER");
        roles.add(userRole);
        customer.setRoles(roles);
        return memberRepository.save(customer); // insert SQL ~
    }
}
