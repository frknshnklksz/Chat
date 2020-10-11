package com.armut.demo.services;

import com.armut.demo.businesslogics.UserRegisterBL;
import com.armut.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRegisterBL userRegisterBL;

    public User insertUser(User user) {
        return userRegisterBL.insertUser(user);
    }

    public String loginUser(User user) {
        return userRegisterBL.loginUser(user);
    }
}
