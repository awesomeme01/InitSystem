package com.example.demo.service;

import com.example.demo.model.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllLastYear();
    List<Attendance> getAllLastMonth();
    List<Attendance> getAllLastWeek();
    List<Attendance> getAllToday();
    List<Attendance> getLastYear();
    List<Attendance> getLastMonth();
    List<Attendance> getLastWeek();
    List<Attendance> getToday();
    List<Attendance> getByUser(Long userId);
    List<Attendance> getByGroup(Long groupId);
    List<Attendance> getByCourse(Long courseId);
    List<Attendance> createAttendance(List<Attendance> l);
    List<Attendance> updateAttendance(List<Attendance> l);

}
