package com.example.demo.service;

import com.example.demo.helper.UserUpdateWrapper;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User createUser(User user);
    User updateUser(UserUpdateWrapper userUpdateWrapper, Long id);
    User getUserById(Long id);
    void deleteUserById(Long id);
}
