package com.example.demo.service;

import com.example.demo.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAll();
    Group getById(Long id);
    Group createGroup(Group group);
    Group updateGroup(Group group);
    void deleteGroup(Long id);

}
