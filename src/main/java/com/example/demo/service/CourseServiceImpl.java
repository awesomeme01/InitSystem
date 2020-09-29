package com.example.demo.service;

import com.example.demo.helper.CourseUpdateWrapper;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(CourseUpdateWrapper courseUpdateWrapper, Long id) {
        Course course;
        course = courseRepository.findById(id).get();
        if(courseUpdateWrapper.getStatus() != null){
            course.setStatus(courseUpdateWrapper.getStatus());
        }
        if(courseUpdateWrapper.getDuration() != null){
            course.setDuration(courseUpdateWrapper.getDuration());
        }
        if(courseUpdateWrapper.getTitle() != null){
            course.setTitle(courseUpdateWrapper.getTitle());
        }
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
