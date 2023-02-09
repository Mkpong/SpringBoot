package com.example.login.service;

import com.example.login.entitiy.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public int logincheck(String id , String password){
        User userTemp;
        try{
            userTemp = userRepository.findById(id).get();
        }catch(Exception e){
            return -1;
        }

        if(password.equals(userTemp.getPassword())) return 1;
        else return 0;

    }

}
