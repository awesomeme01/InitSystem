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
    NewsRepository newsRepository;
    @Autowired
    ProjectService projectService;
    @Override
    public void run(String... args) throws Exception{

        try{
            Course course1 = new Course("Java", 2.5, 1);
            Course course2 = new Course("Javascript", 2.5, 1);
            Course course3 = new Course("Python", 2.5, 1);

            courseService.createCourse(course1);
            courseService.createCourse(course2);
            courseService.createCourse(course3);

            News news = new News("Helloworld", "I'm the new platform for teachers and students in init.kg.", 1, "ROLE_ADMIN");
            News news2 = new News("Helloworld", "I'm the new platform for teachers and students in init.kg.", 1);
            newsRepository.save(news);
            newsRepository.save(news2);

            User user1 = new User.Builder("admin").withName("admin").withGender("male").withPassword("1267476").withPhoneNumber((long)555555555).withEmail("gijdjd@gmail.com").isActive(1).withLevel(4).build();
            User user2 = new User.Builder("ilyas").withName("Ilyas Yangurazov").withGender("male").withPassword("123").withPhoneNumber((long)555348521).withEmail("ilyas@gmail.com").withCourse(course2).isActive(1).withLevel(3).build();
            User user7 = new User.Builder("ratmir").withName("Ratmir").withGender("male").withPassword("123").withPhoneNumber((long)555348530).withEmail("ratmir@gmail.com").isActive(1).withLevel(4).build();
            User user9 = new User.Builder("alish").withName("Alish").withGender("male").withPassword("123").withPhoneNumber((long)555348532).withEmail("alish@gmail.com").isActive(1).withLevel(4).build();
            User user12 = new User.Builder("erkin").withName("Erkin").withGender("male").withPassword("123").withPhoneNumber((long)555348537).withEmail("erkin@gmail.com").withCourse(course3).isActive(1).withLevel(3).build();
            userService.createUser(user1);
            userService.createUser(user2);
            userService.createUser(user7);
            userService.createUser(user9);
            userService.createUser(user12);

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
            Set<Project> projects = new HashSet<>();
            projects.add(project);
            projects.add(project2);
            User userx = userService.getUserByUsername("admin");
            userx.setProjects(projects);

            userService.updateUser(userx, userx.getId());

            UserRole userRole2 = new UserRole("ROLE_ADMIN", user2);
            UserRole userRole8 = new UserRole("ROLE_ADMIN", user7);

            UserRole userRole4 = new UserRole("ROLE_ADMIN", user9);
            UserRole userRole7 = new UserRole("ROLE_ADMIN", user12);
            userRoleService.createUserRole(userRole2);
            userRoleService.createUserRole(userRole4);
            userRoleService.createUserRole(userRole7);
            userRoleService.createUserRole(userRole8);
        }catch(Exception e){
            System.out.println("Couldn't create initial objects, they may have been created already.");
            e.printStackTrace();
        }



    }
}
