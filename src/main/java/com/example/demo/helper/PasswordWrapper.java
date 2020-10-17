package com.example.demo.helper;

import com.example.demo.model.User;

public class PasswordWrapper {
    private String newPassword;

    public PasswordWrapper() {
    }

    public PasswordWrapper(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPassword() {
        return newPassword;
    }

    public void setPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
