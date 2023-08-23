package com.portfolio.projecthandle.service.impl;

import com.portfolio.projecthandle.exception.ResourceNotFoundException;
import com.portfolio.projecthandle.model.Project;
import com.portfolio.projecthandle.repository.ProjectRepository;
import com.portfolio.projecthandle.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        List<Project> all = this.projectRepository.findAll();
        return all;
    }

    @Override
    public Project getProject(int id) {
        Project projectById = this.projectRepository.findById(id).get();
        return projectById;
    }

    @Override
    public void createProject(Project project) {
        this.projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(int id) {
        this.projectRepository.deleteById(id);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

}
