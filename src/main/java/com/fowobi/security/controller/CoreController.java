package com.fowobi.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoreController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/user")
    public String hi() {
        return "user";
    }

    @GetMapping("/admin")
    public String hello2() {
        return "admin";
    }

    @GetMapping("/landing/user")
    public String userLanding() {
        return "welcome";
    }

    @GetMapping("/landing/admin")
    public String adminLanding() {
        return "welcomeadmin";
    }
}
