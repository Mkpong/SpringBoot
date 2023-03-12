package com.example.springboot_study_03.Controller;

import com.example.springboot_study_03.Entity.SiteUser;
import com.example.springboot_study_03.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerservice;

    @PostMapping("/api/register")
    public String register(@RequestBody SiteUser siteuser){
        registerservice.register(siteuser);
        return "Register Success";
    }

}
