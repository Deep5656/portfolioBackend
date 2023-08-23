package com.portfolio.signup.services.impl;

import com.portfolio.signup.model.User;
import com.portfolio.signup.repository.UserRepository;
import com.portfolio.signup.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        List<User> allUser = this.userRepository.findAll();
        return allUser;
    }

    @Override
    public User getUser(int userId) {
        Optional<User> user = this.userRepository.findById(userId);
        return user.get();
    }

    @Override
    public void createUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public boolean validateUser(User user) {
        User userByUserName = this.userRepository.findByUserName(user.getUserName());
        if(userByUserName == null){
            log.debug("No user with this name is present");
            return false;
        }
        log.debug(String.valueOf(userByUserName));
        if(user.getUserName().equals(userByUserName.getUserName()) && user.getPassword().equals(userByUserName.getPassword())){
            return true;
        }
        return false;
    }
}
