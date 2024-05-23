package com.jaewon.security.controller;

import com.jaewon.security.entity.Customer;
import com.jaewon.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberRegister")
    public String memberRegisterGet() {
        return "member/register";   // register.html (회원가입)
    }

    @PostMapping("/memberRegister")
    public String memberRegisterPost(Customer customer) {
        memberService.memberRegister(customer);
        return "redirect:/"; // 시작페이지(index.html)
    }
}
