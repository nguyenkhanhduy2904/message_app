package com.example.message.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse signIn(@RequestBody SigninRequest signinRequest){
        return userService.signIn(signinRequest);
    }

    @GetMapping
    public List<UserResponse> getAllUser(){
        return userService.getAllUser();
    }

}
