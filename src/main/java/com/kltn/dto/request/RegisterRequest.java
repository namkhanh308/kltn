package com.kltn.dto.request;

public class RegisterRequest {
    private String userName;
    private String password;
    private String email;
    private String roles;

    public RegisterRequest(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public RegisterRequest(String userName, String password, String email, String roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public RegisterRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
