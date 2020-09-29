package com.example.demo.contoller;

import com.example.demo.helper.CourseUpdateWrapper;
import com.example.demo.helper.Response;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
//@Secured("")
@RequestMapping("/api/course")
public class CourseController {
    //    List<Course> getAll();
    //    Course createCourse(Course course);
    //    Course updateCourseStatus(Course course, Integer status);
    //    Course getCourseById(Long id);
    //    void deleteById(Long id);
    @Autowired
    CourseService courseService;
    @GetMapping(path="/getAll")
    public Response getAll(){
        return new Response(true, "All courses", courseService.getAll());
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path="/create")
    public Response createCourse(@RequestBody Course course){
        return new Response(true, "Course created", courseService.createCourse(course));
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/update/{id}")
    public Response updateCourse(@RequestBody CourseUpdateWrapper courseUpdateWrapper, @PathVariable Long id){
        return new Response(true, "Course updated", courseService.updateCourse(courseUpdateWrapper, id));
    }
    @Secured("ROLE_USER")
    @GetMapping(path = "/getById/{id}")
    public Response getById(@PathVariable Long id){
        return new Response(true, "Course with id = " + id, courseService.getCourseById(id));
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete/{id}")
    public Response delete(@PathVariable Long id){
        courseService.deleteById(id);
        return new Response(true, "Course with id = " + id + " was deleted!", null);
    }
}
