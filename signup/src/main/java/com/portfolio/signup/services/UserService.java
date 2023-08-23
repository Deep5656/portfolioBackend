package com.portfolio.signup.services;

import com.portfolio.signup.model.User;

import java.util.List;

public interface UserService {

    //get all user
    public List<User> getAll();

    //get single user
    public User getUser(int userId);

    //create user
    public void createUser(User user);

    //validate user
    public boolean validateUser(User user);
}
