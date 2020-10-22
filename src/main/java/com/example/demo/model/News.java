package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "news_init_1")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "isActive", nullable = false)
    private int isActive;
    @Column(name = "forRole")
    private String forRole;
    @Column(name = "dateAdded", nullable = false)
    private LocalDateTime dateAdded;

    public News() {
        this.isActive = 1;
        this.dateAdded = LocalDateTime.now().plusHours(6);
    }

    public News(String title, String description, int isActive, String forRole) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.forRole = forRole;
        this.dateAdded = LocalDateTime.now().plusHours(6);
    }
    public News(String title, String description, int isActive) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.dateAdded = LocalDateTime.now().plusHours(6);
    }

    public Long getId() {
        return id;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getForRole() {
        return forRole;
    }

    public void setForRole(String forRole) {
        this.forRole = forRole;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}
