package com.example.springboot_study_01.Controller;

import com.example.springboot_study_01.Entity.SiteUser;
import com.example.springboot_study_01.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    //회원가입 Controller
    @PostMapping("/api/register")
    public String register(@RequestBody SiteUser siteUser){
        registerService.register(siteUser);
        return "sucess";
    }

}
