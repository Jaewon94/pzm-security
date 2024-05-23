package com.jaewon.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter @Setter
public class CustomerUserDetails extends User { // User(username, password, authorities)

    private Customer customer;  // 로그인에 성공한 고객 정보(이름, 나이, 이메일, 주소 ...)

    public CustomerUserDetails(Customer customer) {
        super(customer.getUsername(), customer.getPassword(), getAuthorities(customer.getRoles()));
        this.customer = customer;
    }
    public static Collection<GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }
}
