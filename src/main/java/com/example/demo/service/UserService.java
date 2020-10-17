package com.example.demo.service;

import com.example.demo.helper.LoginCheck;
import com.example.demo.helper.UserUpdateWrapper;
import com.example.demo.model.Course;
import com.example.demo.model.Project;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    List<User> getUsersByCourse(Course course);
//    User login(LoginCheck loginCheck);
    User createUser(User user);
    User updateUser(UserUpdateWrapper userUpdateWrapper, Long id);
    User getUserById(Long id);
    void deleteUserById(Long id);
    List<User> getByProject(Project project);
    User getUserByUsername(String username);

    User changePassword(User user,String password);
}
