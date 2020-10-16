package com.example.demo.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects_init_1")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "dateCreated")
    private LocalDateTime dateCreated;
    @Column(name = "isCompleted")
    private int isCompleted;
    @ManyToMany(mappedBy = "projects")
    private Set<User> users = new HashSet<>();

    public Project() {
        this.dateCreated = LocalDateTime.now();
        this.isCompleted = 0;
    }

    public Project(String title, String description) {
        this.title = title;
        this.isCompleted = 0;
        this.description = description;
        this.dateCreated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

