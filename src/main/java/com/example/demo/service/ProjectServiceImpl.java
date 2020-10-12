package com.example.demo.service;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }
}
