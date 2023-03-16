package com.example.gladmin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    /**
     * TODO 登陆验证
     * @return Object
     */
    @PostMapping("/login")
    public Object login(){
        return null;
    }

}
