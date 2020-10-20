package com.example.demo.contoller;

import com.example.demo.helper.Response;
import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/attendance")
@Secured("ROLE_ADMIN")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/save")
    public Response saveAttendance(@RequestBody List<Attendance> attendances){
        return new Response(true, "Saved attendance", attendanceService.createAttendance(attendances));
    }
    @GetMapping("/getToday")
    public Response getToday(){
        return new Response(true, "Todays attendance", attendanceService.getToday());
    }
    @GetMapping("/getLastWeek")
    public Response getLastWeek(){
        return new Response(true, "Last weeks attendance", attendanceService.getLastWeek());
    }
    @GetMapping("/getByGroupId/{id}")
    public Response getByGroup(@PathVariable Long id){
        return new Response(true, "Attendance of group with id = " + id, attendanceService.getByGroup(id));
    }
    @GetMapping("/getByCourseId/{id}")
    public Response getByCourse(@PathVariable Long id){
        return new Response(true, "Attendance of course with id = " + id, attendanceService.getByCourse(id));
    }
    @GetMapping("/getByUserId/{id}")
    public Response getByUser(@PathVariable Long id){
        return new Response(true,"Attendnace of user with id = " + id, attendanceService.getByUser(id));
    }
}
