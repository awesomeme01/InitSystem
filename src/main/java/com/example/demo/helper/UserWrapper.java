package com.example.demo.helper;

public class UserWrapper {
    private String username;
    private String fullname;
    private String email;
    private Long phoneNumber;
    private String password;
    private String gender;
    private int isActive;
    private int level;
    private Long courseId;
    private Long groupId;

    public UserWrapper() {
    }

    public UserWrapper(String username, String fullname, String email, Long phoneNumber, String password, String gender, int isActive, int level, Long courseId, Long groupId) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.gender = gender;
        this.isActive = isActive;
        this.level = level;
        this.courseId = courseId;
        this.groupId = groupId;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhonenumber() {
        return phoneNumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long projectId) {
        this.groupId= projectId;
    }
}
