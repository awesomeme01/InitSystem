package com.example.demo.helper;

import com.example.demo.model.Course;
import com.example.demo.model.News;

import java.util.List;

public class Dashboard {
    private Course courses;
    private List<News> news;

    public Dashboard(Course courses, List<News> news) {
        this.courses = courses;
        this.news = news;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}

