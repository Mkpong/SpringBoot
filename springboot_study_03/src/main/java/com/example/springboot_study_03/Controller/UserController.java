package com.example.springboot_study_03.Controller;

import com.example.springboot_study_03.Entity.SiteUser;
import com.example.springboot_study_03.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userservice;

    @GetMapping("/api/user/name")
    public String userName(Principal principal){
        if(principal == null) return null;
        else return principal.getName();
    }

    @GetMapping("/api/user/list")
    public List<SiteUser> userlist(){
        return userservice.userlist();
    }

    @PostMapping("/api/user/delete/{id}")
    public void userdelete(@PathVariable("id") Integer id){
        userservice.userdelete(id);
    }

}
