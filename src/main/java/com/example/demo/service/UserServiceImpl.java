package com.example.demo.service;

import com.example.demo.helper.UserUpdateWrapper;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new  BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        userRoleService.createUserRole(new UserRole("ROLE_USER", user));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserUpdateWrapper userUpdateWrapper, Long id) {
        User user = new User.Builder(userUpdateWrapper.getUsername())
                .withEmail(userUpdateWrapper.getEmail())
                .withGender(userUpdateWrapper.getGender())
                .withPhoneNumber(userUpdateWrapper.getPhoneNumber())
                .withName(userUpdateWrapper.getFullname())
                .withPassword(userUpdateWrapper.getPassword())
                .isActive(userUpdateWrapper.getIsActive()).build();
        return createUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
