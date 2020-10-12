package com.example.demo.helper;

import com.example.demo.model.Project;
import com.example.demo.model.User;

import java.util.List;

public class ProjectUser {
    private List<User> users;
    private Project project;

    public ProjectUser() {
    }

    public ProjectUser(List<User> users, Project project) {
        this.users = users;
        this.project = project;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

