package com.example.springboot_study_03.Service;

import com.example.springboot_study_03.Entity.SiteUser;
import com.example.springboot_study_03.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepository;

    public List<SiteUser> userlist(){
        return userrepository.findAll();
    }


}
