package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.User;
import com.calisto.spring.rest_api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.add(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "Удалено!";
    }

    @PostMapping("/get")
    public User getLoginEndPass(@RequestBody User user){
        System.out.println("Приняли логин и пароль пользователя: " + user.getLogin() + " / " + user.getPassword());
        return userService.getLoginEndPass(user);
    }
}
