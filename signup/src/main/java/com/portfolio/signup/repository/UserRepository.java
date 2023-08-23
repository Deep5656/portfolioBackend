package com.portfolio.signup.repository;

import com.portfolio.signup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUserName(String userName);
}
