package com.portfolio.signup.services;

import java.util.List;

import com.portfolio.signup.model.Project;

public interface ProjectService {

    //get all projects
    public List<Project> getAll();

    //get single project
    public Project getProject(int id);

    //add project
    public void createProject(Project project);

    //delete project
    public void deleteProjectById(int id);

    //update project
    public Project updateProject(Project project);
}
