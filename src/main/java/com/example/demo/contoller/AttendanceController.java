package com.example.demo.contoller;

import com.example.demo.helper.AttendanceWrapper;
import com.example.demo.helper.Response;
import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")

@CrossOrigin(origins = "*")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;
    @Autowired
    UserService userService;
    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public Response saveAttendance(@RequestBody List<AttendanceWrapper> attendances){
        List<Attendance> attendanceList = new ArrayList<>();
        for(AttendanceWrapper x : attendances){
            attendanceList.add(new Attendance(userService.getUserById(x.getUserId()), x.getStatus()));
        }
        return new Response(true, "Saved attendance", attendanceService.createAttendance(attendanceList));
    }
    @Secured("ROLE_USER")
    @GetMapping("/getToday")
    public Response getToday(){
        return new Response(true, "Todays attendance", attendanceService.getToday());
    }
    @Secured("ROLE_USER")
    @GetMapping("/getLastWeek")
    public Response getLastWeek(){
        return new Response(true, "Last weeks attendance", attendanceService.getLastWeek());
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/getByGroupId/{id}")
    public Response getByGroup(@PathVariable Long id){
        return new Response(true, "Attendance of group with id = " + id, attendanceService.getByGroup(id));
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/getByCourseId/{id}")
    public Response getByCourse(@PathVariable Long id){
        return new Response(true, "Attendance of course with id = " + id, attendanceService.getByCourse(id));
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/getByUserId/{id}")
    public Response getByUser(@PathVariable Long id){
        return new Response(true,"Attendnace of user with id = " + id, attendanceService.getByUser(id));
    }
}
