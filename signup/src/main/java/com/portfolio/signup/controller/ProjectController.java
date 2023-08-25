package com.portfolio.signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.signup.model.Project;
import com.portfolio.signup.services.ProjectService;

@RestController
@RequestMapping("/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projectList = projectService.getAll();
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getSingleProject(@PathVariable("id") int id) {
        Project project = projectService.getProject(id);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProject(@RequestBody Project project) {
        projectService.createProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") int id) {
        projectService.deleteProjectById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project, @PathVariable("id") int id) {
        // find project using id
        Project currentProject = projectService.getProject(id);
        // // Copy the updated data to the user
        // BeanUtils.copyProperties(project,currentProject);
        currentProject.setImage(project.getImage());
        currentProject.setTitle(project.getTitle());
        currentProject.setDescription(project.getDescription());
        currentProject.setLink(project.getLink());
        //save updated project to the database
        Project updateProject = projectService.updateProject(currentProject);
        return new ResponseEntity<Project>(updateProject, HttpStatus.OK);
    }

}
