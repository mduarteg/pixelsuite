package com.mx.pixelsoft.pixelsuite.controller;

import com.mx.pixelsoft.pixelsuite.entity.User;
import com.mx.pixelsoft.pixelsuite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

}
