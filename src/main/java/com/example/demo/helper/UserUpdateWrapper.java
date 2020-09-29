package com.example.demo.helper;

public class UserUpdateWrapper {
    private String username;
    private String fullname;
    private String email;
    private String password;
    //        private int age;
    private String gender;
    private int isActive;
    private Long phoneNumber;

    public UserUpdateWrapper() {
    }

    public UserUpdateWrapper(String username, String fullname, String email, String password, String gender, int isActive, Long phoneNumber) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.isActive = isActive;
        this.phoneNumber = phoneNumber;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
