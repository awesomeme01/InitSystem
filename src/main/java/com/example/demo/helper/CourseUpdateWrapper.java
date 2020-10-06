package com.example.demo.helper;

import com.example.demo.model.User;

public class CourseUpdateWrapper {

    private String title;
    private Integer status;
    private Double duration;//month
    private User mentorId;
    private User mentor2Id;

    public CourseUpdateWrapper() {
    }

    public CourseUpdateWrapper(Long id, String title, Integer status, Double duration) {

        this.title = title;
        this.status = status;
        this.duration = duration;
    }

    public CourseUpdateWrapper(String title, Integer status, Double duration, User mentorId, User mentor2Id) {
        this.title = title;
        this.status = status;
        this.duration = duration;
        this.mentorId = mentorId;
        this.mentor2Id = mentor2Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public User getMentorId() {
        return mentorId;
    }

    public void setMentorId(User mentorId) {
        this.mentorId = mentorId;
    }

    public User getMentor2Id() {
        return mentor2Id;
    }

    public void setMentor2Id(User mentor2Id) {
        this.mentor2Id = mentor2Id;
    }
}
