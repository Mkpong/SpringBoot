package com.example.springboot_study_03.Service;

import com.example.springboot_study_03.Entity.SiteUser;
import com.example.springboot_study_03.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserRepository userrepository;

    @Autowired
    private PasswordEncoder passwordencoder;

    public void register(SiteUser siteuser){
        String Encodedpassword = passwordencoder.encode(siteuser.getPassword());
        siteuser.setPassword(Encodedpassword);
        userrepository.save(siteuser);
    }

}
