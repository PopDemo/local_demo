package com.example.demo.controller;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {


    @PostMapping("/getUser")
    public String getMember(String memberId){
        return "Yangfan";
    }

}
