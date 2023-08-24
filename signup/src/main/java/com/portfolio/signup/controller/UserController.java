package com.portfolio.signup.controller;

import com.portfolio.signup.model.User;
import com.portfolio.signup.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin("https://portfoliosignup-production.up.railway.app/user")
public class UserController {
    @Autowired
    private UserService userService;

    //get all users
    @GetMapping
    public ResponseEntity<List<User>>getAllUser(){
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User>getSingleUser(@PathVariable("userId") int userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //create user
    @PostMapping
    public ResponseEntity<Void>createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //validate user
    @PostMapping("/validate")
    public boolean validate(@RequestBody User user){
        boolean b = userService.validateUser(user);
        return b;
    }

}
