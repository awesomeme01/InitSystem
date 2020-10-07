//package com.example.demo.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "mentor_init_1")
//public class Mentor {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private User mentorId;
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course courseId;
//
//    public Mentor() {
//    }
//
//    public Mentor(User mentorId, Course courseId) {
//        this.mentorId = mentorId;
//        this.courseId = courseId;
//    }
//
//    public User getMentorId() {
//        return mentorId;
//    }
//
//    public void setMentorId(User mentorId) {
//        this.mentorId = mentorId;
//    }
//
//    public Course getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Course courseId) {
//        this.courseId = courseId;
//    }
//}
