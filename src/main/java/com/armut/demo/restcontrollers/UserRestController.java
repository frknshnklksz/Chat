package com.armut.demo.restcontrollers;

import com.armut.demo.messages.exceptionmessages.Exceptions;
import com.armut.demo.messages.succesmessages.Success;
import com.armut.demo.models.User;
import com.armut.demo.path.UserPaths;
import com.armut.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {


    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = UserPaths.REGISTER_USER)
    public String insertUser(@RequestBody User user){
        try {
            userService.insertUser(user);
            return Success.INSERT_SUCCESS;
        }catch (Exception e){
            return Exceptions.INSERT_EXCEPTION + "\nfor more detail\n" + e.getMessage();
        }
    }

    @GetMapping(value = UserPaths.LOGIN_USER)
    public String loginUser(@RequestBody User user){
        try{
            return userService.loginUser(user);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
