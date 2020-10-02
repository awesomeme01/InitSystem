package com.example.demo.bootstrap;

import com.example.demo.model.Course;
import com.example.demo.model.Group;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class   BootstrapMain implements CommandLineRunner {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception{
        //Initial users

        //Initial UserRoles


        //Initial Course

        Course course1 = new Course("Java", 2.5, 1);
        Course course2 = new Course("Javascript", 2.5, 1);
        Course course3 = new Course("Python", 2.5, 1);

        courseService.createCourse(course1);
        courseService.createCourse(course2);

        Group group1 = new Group("JS Morning", course2);
        Group group2 = new Group("JS Evening", course2);
        Group group3 = new Group("Python Morning", course2);
        Group group4 = new Group("Python Evening", course2);



        User user1 = new User.Builder("shabdan").withName("Shabdan Abzhaparov").withGender("male").withPassword("123").withPhoneNumber((long)555348520).withEmail("sh.abjaparov@gmail.com").withCourse(course1).isActive(1).build();
        User user2 = new User.Builder("ilyas").withName("Ilyas Yangurazov").withGender("male").withPassword("123").withPhoneNumber((long)555348521).withEmail("ilyas@gmail.com").withCourse(course2).isActive(1).build();
        User user6 = new User.Builder("danya").withName("Daniar Chekirov").withGender("male").withPassword("123").withPhoneNumber((long)555348529).withEmail("danya@gmail.com").withCourse(course2).isActive(1).build();
        User user5 = new User.Builder("aito").withName("Aitemir").withGender("male").withPassword("123").withPhoneNumber((long)555348528).withEmail("aito@gmail.com").withCourse(course3).isActive(1).build();
        User user3 = new User.Builder("aibek").withName("Aibek Aibekov").withGender("male").withPassword("123").withPhoneNumber((long)555348522).withEmail("aibek@gmail.com").isActive(1).withGroup(group1).build();
        User user4 = new User.Builder("kairat").withName("Kairat Kairatov").withGender("male").withPassword("123").withPhoneNumber((long)555348523).withEmail("kairat@gmail.com").withGroup(group1).isActive(1).build();
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);
        userService.createUser(user5);
        userService.createUser(user6);
        UserRole userRole1 = new UserRole("ROLE_ADMIN", user1);
        UserRole userRole2 = new UserRole("ROLE_ADMIN", user2);
        UserRole userRole3 = new UserRole("ROLE_STUDENT", user3);
        UserRole userRole4 = new UserRole("ROLE_STUDENT", user4);
        UserRole userRole5 = new UserRole("ROLE_USER", user1);
        UserRole userRole6 = new UserRole("ROLE_USER", user2);
        UserRole userRole7 = new UserRole("ROLE_USER", user3);
        UserRole userRole8 = new UserRole("ROLE_USER", user4);
        UserRole userRole9 = new UserRole("ROLE_ADMIN", user5);
        UserRole userRole10 = new UserRole("ROLE_ADMIN", user6);
        userRoleService.createUserRole(userRole1);
        userRoleService.createUserRole(userRole2);
        userRoleService.createUserRole(userRole3);
        userRoleService.createUserRole(userRole4);
        userRoleService.createUserRole(userRole5);
        userRoleService.createUserRole(userRole6);
        userRoleService.createUserRole(userRole7);
        userRoleService.createUserRole(userRole8);

    }
}
