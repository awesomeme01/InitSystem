package com.example.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "course_init_1")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", unique = false, length = 50,nullable = false)
    private String title;
    @Column(name = "duration", unique = false)
    private Double duration;//month
    @Column(name = "status", unique = false)
    private Integer status;
    @Column(name = "dateStarted",unique = false )
    private LocalDateTime date;
    @Transient
    private List<Mentor> mentors;

    public Course() {
    }

    public Course(String title, Double duration, Integer status) {
        this.title = title;
        this.status = status;
        this.duration = duration;
        this.date = LocalDateTime.now();
    }
    public Course(String title, Double duration, Integer status, User mentor, User mentor2) {
        this.title = title;
        this.status = status;
        this.duration = duration;
        this.date = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
    }
}
