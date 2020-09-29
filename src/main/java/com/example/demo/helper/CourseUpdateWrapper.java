package com.example.demo.helper;

public class CourseUpdateWrapper {

    private String title;
    private Integer status;
    private Double duration;//month

    public CourseUpdateWrapper() {
    }

    public CourseUpdateWrapper(Long id, String title, Integer status, Double duration) {

        this.title = title;
        this.status = status;
        this.duration = duration;
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
}
