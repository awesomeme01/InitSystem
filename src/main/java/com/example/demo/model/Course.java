package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "course_init_1")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", unique = true, length = 50,nullable = false)
    private String title;
    @Column(name = "duration", unique = false)
    private Double duration;//month
    @Column(name = "status", unique = false)
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private User user;

    public Course() {
    }

    public Course(String title, Double duration, Integer status) {
        this.title = title;
        this.status = status;
        this.duration = duration;
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
}
