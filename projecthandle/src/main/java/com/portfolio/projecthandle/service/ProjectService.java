package com.portfolio.projecthandle.service;

import com.portfolio.projecthandle.model.Project;

import java.util.List;

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
