package com.example.demo.service;

import com.example.demo.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project create(Project project);
}
