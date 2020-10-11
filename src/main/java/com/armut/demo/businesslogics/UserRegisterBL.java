package com.armut.demo.businesslogics;

import com.armut.demo.messages.exceptionmessages.Exceptions;
import com.armut.demo.messages.succesmessages.Success;
import com.armut.demo.models.StateOfUser;
import com.armut.demo.models.User;
import com.armut.demo.repositories.UserRepository;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRegisterBL {

    private final UserRepository userRepository;

    public UserRegisterBL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insertUser(User user) {
        JSONObject userName = userRepository.findByUserName(user.getUserName());
        String email = userRepository.findByEmail(user.getEmail());


        if (user.getUserName() == null || (userNameControl(user.getUserName()) != true)){
            throw new IllegalArgumentException(Exceptions.USER_NAME_LENGTH_EXCEPTION);
        }
        else if (userName != null){
            throw new IllegalArgumentException(Exceptions.EXISTS_USERNAME);
        }else if (emailControl(user.getEmail()) != true){
            throw new IllegalArgumentException(Exceptions.INVALID_EMAIL);
        }else if (passwordControl(user.getPassword()) != true){
            throw new IllegalArgumentException(Exceptions.PASSWORD_LENGTH_EXCEPTION);
        }else if (email != null){
            throw new IllegalArgumentException(Exceptions.EXISTS_EMAIL);
        }

        return userRepository.insert(user);
    }

    private boolean passwordControl(String password){
        if (password.length() < 8){
            return false;
        }else return true;
    }

    private boolean emailControl(String email){
        if (!email.contains("@")){
            return false;
        }else return true;
    }

    private boolean userNameControl(String userName) {
        if (userName.length() < 3) {
            return false;
        }else return true;
    }


    public String loginUser(User user) {
        JSONObject userName = userRepository.findByUserName(user.getUserName());
        System.out.println("json: " + userName);
        String password = userName.get("password").toString();
        String nameOfUser = userName.get("userName").toString();


        if ( !nameOfUser.isEmpty() && (nameOfUser.equals(user.getUserName())) && user.getPassword() != null && (password.equals(user.getPassword())) ){
                user.setState(StateOfUser.Login);
                return Success.LOGIN_SUCCESS;
        }else {
            return Exceptions.LOGIN_EXCEPTION;
        }

    }
}
