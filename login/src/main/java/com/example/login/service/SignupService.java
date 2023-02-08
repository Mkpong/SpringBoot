
package com.example.login.service;

import com.example.login.entitiy.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user){

        userRepository.save(user); //DB에 JPA를 통해서 저장

    }

}

