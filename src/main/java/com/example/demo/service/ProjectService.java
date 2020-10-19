package com.example.demo.service;

import com.example.demo.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project create(Project project);
    Project setCompleted(Long projectId, int isCompleted);

    Project updateProject(Long id, Project project);
    void deleteProject(Long id);
}
