package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAll();
    List<UserRole> getRolesByUserId(Long id);
    UserRole createUserRole(UserRole userRole);
    void deleteUserRole(Long id);
}
