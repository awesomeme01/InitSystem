package com.example.demo.service;

import com.example.demo.helper.CourseUpdateWrapper;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    MentorRepository mentorRepository;
    @Override
    public List<Course> getAll() {
        List<Course> courses = courseRepository.findAll();
        for(Course c : courses){
            c.setMentors(mentorRepository.findAll().stream().filter(x->x.getCourseId().equals(c.getId())).collect(Collectors.toList()));
        }
        return courses;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(CourseUpdateWrapper courseUpdateWrapper, Long id) {
        Course course;
//        courseRepository.
        course = courseRepository.findById(id).get();
//        courseRepository.delete(course);
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
