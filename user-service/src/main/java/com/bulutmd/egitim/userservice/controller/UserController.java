package com.bulutmd.egitim.userservice.controller;

import com.bulutmd.egitim.userservice.model.User;
import com.bulutmd.egitim.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.listAllUsers();
    }

    @PostMapping
    public User saveOrUpdate(@RequestBody User user) {
        return userService.save(user);
    }

}
