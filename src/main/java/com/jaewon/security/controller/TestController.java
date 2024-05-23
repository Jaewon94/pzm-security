package com.jaewon.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class TestController {


    @Secured("ROLE_MANAGER")
    @GetMapping("/info")
    @ResponseBody
    public String info() {
        return "개인정보";
    }

//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "관리자 정보";
    }
}
