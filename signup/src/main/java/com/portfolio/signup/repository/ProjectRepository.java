package com.portfolio.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.signup.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer>{
    
}
