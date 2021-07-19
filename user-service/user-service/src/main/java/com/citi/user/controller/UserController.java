package com.citi.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.citi.user.VO.ResponseTemplateVO;
import com.citi.user.entity.User;
import com.citi.user.service.UserService;

@RestController
@RequestMapping("/users")
 
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        return userService.getUserWithDepartment(userId);
    }


}