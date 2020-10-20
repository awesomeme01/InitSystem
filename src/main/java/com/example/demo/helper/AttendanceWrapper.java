package com.example.demo.helper;

public class AttendanceWrapper {
    private Long userId;
    private int status;

    public AttendanceWrapper() {
    }

    public AttendanceWrapper(Long userId, int status) {
        this.userId = userId;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
