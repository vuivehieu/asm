package com.example.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping(value = "/sign-in")
    public String showSignInForm(){
        return "signin";
    }
    @GetMapping(value = "/sign-up")
    public String showSignUpForm(){
        return "signup";
    }
}
