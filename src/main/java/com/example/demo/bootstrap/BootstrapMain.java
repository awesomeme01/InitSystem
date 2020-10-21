package com.example.demo.bootstrap;

import com.example.demo.helper.CourseUpdateWrapper;
import com.example.demo.model.*;
//import com.example.demo.repository.MentorRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapMain implements CommandLineRunner {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    GroupService groupService;
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    ProjectService projectService;
//    @Autowired

//    MentorRepository mentorRepository;
    @Override
    public void run(String... args) throws Exception{

        Course course1 = new Course("Java", 2.5, 1);
        Course course2 = new Course("Javascript", 2.5, 1);
        Course course3 = new Course("Python", 2.5, 1);

        courseService.createCourse(course1);
        courseService.createCourse(course2);
        courseService.createCourse(course3);

        Group group1 = new Group("JS Morning", course2);
        Group group2 = new Group("JS Evening", course2);
        Group group3 = new Group("Python Morning", course2);
        Group group4 = new Group("Python Evening", course2);

        groupService.createGroup(group1);
        groupService.createGroup(group2);
        groupService.createGroup(group3);
        groupService.createGroup(group4);


        News news = new News("Helloworld", "I'm the new platform for teachers and students in init.kg.", 1, "ROLE_ADMIN");
        News news2 = new News("Helloworld", "I'm the new platform for teachers and students in init.kg.", 1);
        newsRepository.save(news);
        newsRepository.save(news2);
        Project project = new Project("Платформа инит", "1 неделя");
        project.setIsCompleted(1);
        Project project2 = new Project("Медицинский сайт", "2 месяца");
        Project project3 = new Project("Сделать чат", "3 недели");
        Project project4= new Project("Сделать сайт для автомойки", "2 недели");
        Project project5 = new Project("Набрать 10к подписчиков", "3 месяца");
        projectService.create(project);
        projectService.create(project2);
        projectService.create(project3);
        projectService.create(project4);
        projectService.create(project5);

        User user1 = new User.Builder("shabdan").withName("Shabdan Abzhaparov").withGender("male").withPassword("123").withPhoneNumber((long)555348520).withEmail("sh.abjaparov@gmail.com").withCourse(course1).isActive(1).withLevel(3).build();
        User user2 = new User.Builder("ilyas").withName("Ilyas Yangurazov").withGender("male").withPassword("123").withPhoneNumber((long)555348521).withEmail("ilyas@gmail.com").withCourse(course2).isActive(1).withLevel(3).build();
        User user6 = new User.Builder("danya").withName("Daniar Chekirov").withGender("male").withPassword("123").withPhoneNumber((long)555348529).withEmail("danya@gmail.com").withCourse(course2).isActive(1).withLevel(2).build();
        User user5 = new User.Builder("aito").withName("Aitemir").withGender("male").withPassword("123").withPhoneNumber((long)555348528).withEmail("aito@gmail.com").withCourse(course3).isActive(1).withLevel(3).build();
        User user3 = new User.Builder("aibek").withName("Aibek Aibekov").withGender("male").withPassword("123").withPhoneNumber((long)555348522).withEmail("aibek@gmail.com").isActive(1).withLevel(1).build();
        User user4 = new User.Builder("kairat").withName("Kairat Kairatov").withGender("male").withPassword("123").withPhoneNumber((long)555348523).withEmail("kairat@gmail.com").isActive(1).withLevel(1).build();
        User user7 = new User.Builder("ratmir").withName("Ratmir").withGender("male").withPassword("123").withPhoneNumber((long)555348530).withEmail("ratmir@gmail.com").isActive(1).withLevel(4).build();
        User user8 = new User.Builder("asein").withName("Asein").withGender("male").withPassword("123").withPhoneNumber((long)555348531).withEmail("asein@gmail.com").isActive(1).withLevel(4).build();
        User user9 = new User.Builder("alish").withName("Alish").withGender("male").withPassword("123").withPhoneNumber((long)555348532).withEmail("alish@gmail.com").isActive(1).withLevel(4).build();
        User user10 = new User.Builder("altyn").withName("Altynbek").withGender("male").withPassword("123").withPhoneNumber((long)555348534).withEmail("altysh@gmail.com").withCourse(course3).isActive(1).withLevel(2).build();
        User user11 = new User.Builder("aika").withName("Aika").withGender("female").withPassword("123").withPhoneNumber((long)555348536).withEmail("aika@gmail.com").withCourse(course2).isActive(1).withLevel(4).build();
        User user12 = new User.Builder("erkin").withName("Erkin").withGender("male").withPassword("123").withPhoneNumber((long)555348537).withEmail("erkin@gmail.com").withCourse(course3).isActive(1).withLevel(3).build();
//        Set<Project> projects = new HashSet<>();
//        projects.add(project);
//        projects.add(project2);
//        user1.setProjects(projects);

        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);
        userService.createUser(user5);
        userService.createUser(user6);
        userService.createUser(user7);
        userService.createUser(user8);
        userService.createUser(user9);
        userService.createUser(user10);
        userService.createUser(user11);
        userService.createUser(user12);


//        //(String title, Integer status, Double duration, User mentorId, User mentor2Id)
//        mentorRepository.save(new Mentor(user2, course2));
//        mentorRepository.save(new Mentor(user6, course2));
//        mentorRepository.save(new Mentor(user5, course3));
//        mentorRepository.save(new Mentor(user1, course1));


        UserRole userRole1 = new UserRole("ROLE_ADMIN", user1);
        UserRole userRole2 = new UserRole("ROLE_ADMIN", user2);
        UserRole userRole8 = new UserRole("ROLE_ADMIN", user7);

        UserRole userRole3 = new UserRole("ROLE_ADMIN", user8);
        UserRole userRole4 = new UserRole("ROLE_ADMIN", user9);
//        UserRole userRole1 = new UserRole("ROLE_ADMIN", user1);
//        UserRole userRole5 = new UserRole("ROLE_ADMIN", user10);
//        UserRole userRole1 = new UserRole("ROLE_ADMIN", user1);
        UserRole userRole6 = new UserRole("ROLE_ADMIN", user11);
//        UserRole userRole1 = new UserRole("ROLE_ADMIN", user1);1
//        UserRole userRole7 = new UserRole("ROLE_ADMIN", user12);
        userRoleService.createUserRole(userRole1);
        userRoleService.createUserRole(userRole2);
        userRoleService.createUserRole(userRole3);
        userRoleService.createUserRole(userRole4);
//        userRoleService.createUserRole(userRole5);
        userRoleService.createUserRole(userRole6);
//        userRoleService.createUserRole(userRole7);
        userRoleService.createUserRole(userRole8);


    }
}
