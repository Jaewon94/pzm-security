package com.jaewon.security.repository;

import com.jaewon.security.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Customer, Long> {
}
