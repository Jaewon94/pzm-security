package com.jaewon.security.service;

import com.jaewon.security.entity.Customer;
import com.jaewon.security.entity.CustomerUserDetails;
import com.jaewon.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override   // 사용자가 입력한 username, password
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername 실행");

        // 데이터베이스에서 username의 정보를 가지고 온다.
        Optional<Customer> optional = memberRepository.findByUsername(username);

        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("Username not found : " + username);
        }
        Customer customer = optional.get();
        /*
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer); ${customer.username}
         */
        return new CustomerUserDetails(customer);    // 비밀번호 검사 ---> SecurityContextHolder(HttpSession)
    }
}

/*
    SecurityContextHolder : UserDetails <-- interface
                                |
                                | implements
                                |
                                User
                                | extends
                            CustomerUserDetails
 */
