package com.jayant.JobAppWithJpa.service;
import com.jayant.JobAppWithJpa.model.User;
import com.jayant.JobAppWithJpa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    // Strength is the number of rounds password has been Bcrypted

    @Autowired
    private UserRepo repo;

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);
    }
}
