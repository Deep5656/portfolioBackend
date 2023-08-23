package com.portfolio.projecthandle.repository;

import com.portfolio.projecthandle.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
