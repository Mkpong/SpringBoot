package com.example.login.controller;

import com.example.login.entitiy.User;
import com.example.login.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupservice;

    @PostMapping("/signup")
    public String signup(){
        return "signup";
    }


    @PostMapping("/signup/pro")
    public String signupPro(User user , Model model){

        signupservice.register(user);

        //id 중복체크 구현

        model.addAttribute("message" , "회원가입이 완료되었습니다.");
        model.addAttribute("searchUrl" ,  "/login");

        return "message";
    }

    @GetMapping("/login")
    public String loginPage(){


        return "loginpage";
    }

    @PostMapping("/login/pro")
    public String loginPro(Model model){

        //ID와 PW가 일치하는지 확인

        //일치하면 board page로 이동

        //일치하지 않으면 message후 login page로 이동

        model.addAttribute("message" , "로그인을 시도하셨습니다.");
        model.addAttribute("searchUrl" , "/board");

        return "message";
    }



}
