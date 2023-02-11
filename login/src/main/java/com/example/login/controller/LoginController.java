package com.example.login.controller;

import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginservice;

    @GetMapping("/login")
    public String loginPage(){
        return "Login/loginpage";
    }

    @GetMapping("/login/admin")
    public String loginAdmin(Model model){
        model.addAttribute("list" , loginservice.userList());

        return "Login/loginadmin";
    }

    @GetMapping("/login/admin/userdelete")
    public String userDelete(String id, Model model){
        int check = loginservice.userDelete(id);
        if(check == 1){
            model.addAttribute("message" , "삭제가 완료되었습니다.");
            model.addAttribute("searchUrl"  , "/login/admin");
        }
        else{
            model.addAttribute("message" , "관리자 계정은 삭제할 수 없습니다.");
            model.addAttribute("searchUrl"  , "/login/admin");
        }
        return "message";
    }

    @PostMapping("/login/pro")
    public String loginPro(Model model , String id , String password){

        int check;
        check = loginservice.logincheck(id, password);

        if(check == -1){
            model.addAttribute("message" , "아이디가 일치하지 않습니다.");
            model.addAttribute("searchUrl" , "/login");
            return "message";
        }
        else if(check == 0){
            model.addAttribute("message" , "비밀번호가 일치하지 않습니다.");
            model.addAttribute("searchUrl" , "/login");
            return "message";
        }

        if(id.equals("admin") && password.equals("admin")){
            model.addAttribute("message" , "관리자페이지로 이동합니다.");
            model.addAttribute("searchUrl" , "/login/admin");
            return "message";

        }

        model.addAttribute("message" , "로그인이 완료되었습니다.");
        model.addAttribute("searchUrl" , "/board/list");
        return "message";
    }

    @GetMapping("/logout/pro")
    public String logoutpro(Model model){
        model.addAttribute("message" , "로그아웃이 완료되었습니다.");
        model.addAttribute("searchUrl" , "/login");
        return "message";
    }



}
