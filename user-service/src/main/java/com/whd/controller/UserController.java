package com.whd.controller;


import com.whd.model.User;
import com.whd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/getUserByIdAll")
    public User getUserById(){
        User user = userService.getUserById(1);
        user.setId(this.port);
        return user;
    }
    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(1);
    }
}
