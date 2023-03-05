package com.example.springboot_study_01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserSecurityController {

    @GetMapping("/api/user")
    public String userName(Principal principal){
        if(principal == null) return "no user";
        return principal.getName();
    }

    @GetMapping("/api/logcheck")
    public boolean logCheck(Principal principal){
        if(principal == null){
            System.out.println("HOLYMOLY");
            return false;
        }
        else return true;
    }

}
