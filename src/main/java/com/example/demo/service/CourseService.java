package com.example.demo.service;

import com.example.demo.helper.CourseUpdateWrapper;
import com.example.demo.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course createCourse(Course course);
    Course updateCourse(CourseUpdateWrapper courseUpdateWrapper, Long id    );
    Course getCourseById(Long id);
    void deleteById(Long id);
}
