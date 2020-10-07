//package com.example.demo.contoller;
//
//import com.example.demo.helper.Response;
//import com.example.demo.model.Mentor;
//import com.example.demo.repository.MentorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/mentors")
//public class MentorController {
//    @Autowired
//    MentorRepository mentorRepository;
//
//    @Secured("ROLE_ADMIN")
//    @PostMapping("/create")
//    public Response create(@RequestBody Mentor mentor){
//        return new Response(true, "created mentor constraint", mentorRepository.save(mentor));
//    }
//    @Secured({"ROLE_ADMIN", "ROLE_STUDENT"})
//    @GetMapping("/getMentorsByCourse/{courseId}")
//    public Response getByCourseId(@PathVariable Long courseId){
//        return new Response(true, "getByCourseId", mentorRepository.findAll().stream().filter(x->x.getCourseId().equals(courseId)).collect(Collectors.toList()));
//
//    }
//
//}
