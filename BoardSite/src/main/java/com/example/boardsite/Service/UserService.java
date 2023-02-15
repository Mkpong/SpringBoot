package com.example.boardsite.Service;

import com.example.boardsite.Entity.SiteUser;
import com.example.boardsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SiteUser register(SiteUser user){
        String EncodedPassword =passwordEncoder.encode(user.getPassword());
        user.setPassword(EncodedPassword);
        return userRepository.save(user);
    }

}
