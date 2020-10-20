package com.example.demo.service;

import com.example.demo.model.Attendance;
import com.example.demo.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    CourseService courseService;

    @Override
    public List<Attendance> getAllLastYear() {
        return null;
    }

    @Override
    public List<Attendance> getAllLastMonth() {
        return null;
    }

    @Override
    public List<Attendance> getAllLastWeek() {
        return null;
    }

    @Override
    public List<Attendance> getAllToday() {
        return null;
    }

    @Override
    public List<Attendance> getLastYear() {
        return null;
    }

    @Override
    public List<Attendance> getLastMonth() {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        return attendanceRepository.findAll().stream().filter(x->{
//            return x.getLocalDateTime().getDayOfMonth() <= localDateTime.getDayOfMonth() &&
//                    x.getLocalDateTime().getDayOfMonth() > (localDateTime.getDayOfMonth() - 7) &&
//                    x.getLocalDateTime().getMonthValue() == localDateTime.getMonthValue() &&
//                    x.getLocalDateTime().getYear() == localDateTime.getYear();
//        }).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Attendance> getLastWeek() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return attendanceRepository.findAll().stream().filter(x->{
            return x.getLocalDateTime().getDayOfMonth() <= localDateTime.getDayOfMonth() &&
                    x.getLocalDateTime().getDayOfMonth() > (localDateTime.getDayOfMonth() - 7) &&
                    x.getLocalDateTime().getMonthValue() == localDateTime.getMonthValue() &&
                    x.getLocalDateTime().getYear() == localDateTime.getYear();
        }).collect(Collectors.toList());
    }

    @Override
    public List<Attendance> getToday() {
        LocalDateTime localDateTime = LocalDateTime.now();
        List list1 = attendanceRepository.findAll().stream().filter(x->{
            return x.getLocalDateTime().getDayOfMonth() == localDateTime.getDayOfMonth() &&
                    x.getLocalDateTime().getMonthValue() == localDateTime.getMonthValue() &&
                    x.getLocalDateTime().getYear() == localDateTime.getYear();
        }).collect(Collectors.toList());
        return list1;
    }

    @Override
    public List<Attendance> getByGroup(Long groupId) {
        return attendanceRepository.findAll().stream().filter(x->x.getUser().getGroup().getId().equals(groupId)).collect(Collectors.toList());

    }

    @Override
    public List<Attendance> getByCourse(Long courseId) {
        return attendanceRepository.findAll().stream().filter(x->x.getUser().getCourse().getId().equals(courseId)).collect(Collectors.toList());
    }

    @Override
    public List<Attendance> createAttendance(List<Attendance> l) {
        List<Attendance> beforeForToday = getToday();
        List<Attendance> newData = new ArrayList<>();
        for(Attendance a : l){
            for(Attendance b : beforeForToday){
                if(a.getUser().equals(b.getUser())){
                    attendanceRepository.deleteById(b.getId());
                }
            }
            newData.add(a);
        }
        return attendanceRepository.saveAll(newData);
    }

    @Override
    public List<Attendance> updateAttendance(List<Attendance> l) {
        return attendanceRepository.saveAll(l);
    }

    @Override
    public List<Attendance> getByUser(Long userId) {
        return attendanceRepository.findAll().stream().filter(x->x.getUser().getId().equals(userId)).collect(Collectors.toList());
    }
}
