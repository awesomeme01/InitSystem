package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

@Table(name = "user_init_1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = false, length = 50)
    private String username;
    @Column(name = "fullname", nullable = false, unique = false, length = 50)
    private String fullname;
    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;
    @Column(name = "phone_number", nullable = true, unique = true, length = 50)
    private Long phoneNumber;

    @Column(name = "password", nullable = true, unique = false, length = 200)
    private String password;

    @Column(name = "gender", nullable = false, unique = false, length = 10)
    private String gender;
    @Column(name = "is_active", nullable = false)
    private int isActive;
    @Column(name = "level")
    private int level;
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_project",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    Set<Project> projects = new HashSet<>();

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @OneToMany(mappedBy = "course")
//    private Set<Course> courses;

    private User(){
        this.isActive = 1;
    }
    public static class Builder{
        private String username;
        private String fullname;
        private String email;
        private String password;
//        private int age;
        private String gender;
        private int isActive;
        private Long phoneNumber;
        private Course course;
        private int level;
        private Group group;
        Set<Project> projects = new HashSet<>();
        public Builder(String username){
            this.username = username;
            this.isActive = 1;
        }

        public Builder withName(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public Builder withLevel(int level){
            this.level = level;
            return this;
        }
        public Builder withProjects(Set<Project> projects){
            this.projects = projects;
            return this;
        }
        public Builder withPhoneNumber(Long phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder withCourse(Course course){
            this.course = course;
            return this;
        }
        public Builder withGroup(Group group){
            this.group = group;
            return this;
        }
        public Builder withPassword(String password){
            this.password = password;
            return this;
        }
//
//        public Builder withAge(int age) {
//            this.age = age;
//            return this;
//        }

        public Builder withGender(String gender){
            this.gender = gender;
            return this;
        }

        public Builder isActive(int isActive){
            this.isActive = isActive;
            return this;
        }

        public User build(){
            User user1 = new User();
            user1.username = this.username;
            user1.email = this.email;
            user1.password = this.password;
            user1.fullname = this.fullname;
            user1.level = this.level;
            user1.course = this.course;
            user1.group = this.group;
            user1.projects = this.projects;
            user1.gender = this.gender;
            user1.isActive = this.isActive;
            user1.phoneNumber = this.phoneNumber;
            return user1;
        }

    }

    public Long getId() {
        return id;
    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getLevel() {
        return level;
    }

    public Set<Project> getProject() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
