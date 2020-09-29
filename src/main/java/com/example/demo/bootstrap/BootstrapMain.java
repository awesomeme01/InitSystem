package com.example.demo.bootstrap;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapMain implements CommandLineRunner {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception{
        //Initial users
        User user1 = new User.Builder("shabdan").withName("Shabdan Abzhaparov").withGender("male").withPassword("123").withPhoneNumber((long)555348520).withEmail("sh.abjaparov@gmail.com").isActive(1).build();
        User user2 = new User.Builder("ilyas").withName("Ilyas Yangurazov").withGender("male").withPassword("123").withPhoneNumber((long)555348520).withEmail("ilyas@gmail.com").isActive(1).build();
        User user3 = new User.Builder("Aibek").withName("Aibek Aibekov").withGender("male").withPassword("123").withPhoneNumber((long)555348520).withEmail("aibek@gmail.com").isActive(1).build();
        User user4 = new User.Builder("Kairat").withName("Kairat Kairatov").withGender("male").withPassword("123").withPhoneNumber((long)555348520).withEmail("kairat@gmail.com").isActive(1).build();
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);
        //Initial UserRoles
        UserRole userRole1 = new UserRole("ROLE_ADMIN", user1);
        UserRole userRole2 = new UserRole("ROLE_ADMIN", user2);
        UserRole userRole3 = new UserRole("ROLE_ADMIN", user3);
        UserRole userRole4 = new UserRole("ROLE_ADMIN", user4);
        userRoleService.createUserRole(userRole1);
        userRoleService.createUserRole(userRole2);
        userRoleService.createUserRole(userRole3);
        userRoleService.createUserRole(userRole4);
        //Initial Courses
        Course course1 = new Course("Java", 2.5, 1);
        Course course2 = new Course("Python", 2.5, 1);


    }
}
