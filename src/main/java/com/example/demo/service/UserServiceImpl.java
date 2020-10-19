package com.example.demo.service;

import com.example.demo.helper.LoginCheck;
import com.example.demo.helper.PasswordWrapper;
import com.example.demo.helper.UserUpdateWrapper;
import com.example.demo.model.Course;
import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User changePassword(PasswordWrapper passwordWrapper) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newP = passwordEncoder.encode(passwordWrapper.getNewPassword());
        User user = passwordWrapper.getUser();
        user.setPassword(newP);
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
    public List<User> getByProject(Project project) {
        return userRepository.findAll().stream().filter(x->{
            if(x.getProject() != null)
                return x.getProject().equals(project);
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<User> getUsersByCourse(Course course){
        return userRepository.findAll().stream().filter(x->{
            if(x.getCourse()!=null){
                if(x.getCourse().equals(course)){
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }
//    @Override
//    public User login(LoginCheck loginCheck){
//        BCryptPasswordEncoder p = new BCryptPasswordEncoder();
//        User user;
//        for(User c: userRepository.findAll()){
//            if(c.getUsername().equals(loginCheck.getUsername())){
//                user = c;
//            }
//        }
//        userService.
//        return
//    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
