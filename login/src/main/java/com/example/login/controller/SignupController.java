package com.example.login.controller;

import com.example.login.entitiy.User;
import com.example.login.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupservice;

    @PostMapping("/signup")
    public String signup(){
        return "/Login/signup";
    }


    @PostMapping("/signup/pro")
    public String signupPro(User user , Model model){

        boolean check = signupservice.idduplication(user.getId());
        if(check){
            System.out.println("TEST");
            model.addAttribute("message" , "중북된 아이디입니다. 다시 입력하세요");
            model.addAttribute("searchUrl" , "/login");

            return "message";
        }
        signupservice.register(user);

        model.addAttribute("message" , "회원가입이 완료되었습니다.");
        model.addAttribute("searchUrl" ,  "/login");

        return "message";
    }






}
