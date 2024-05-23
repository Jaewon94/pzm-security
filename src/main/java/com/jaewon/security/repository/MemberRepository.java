package com.jaewon.security.repository;

import com.jaewon.security.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Customer, Long> {

    public Optional<Customer> findByUsername(String username);
}
