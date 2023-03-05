package com.example.springboot_study_01.Service;

import com.example.springboot_study_01.Entity.SiteUser;
import com.example.springboot_study_01.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(SiteUser user){
        String EncodedPassword =passwordEncoder.encode(user.getPassword());
        user.setPassword(EncodedPassword);
        userRepository.save(user);
    }

}
