package com.kltn.dto.respone;


public class ResponeToken {
    private String token;
    private String roles;
    private String id_User;

    public ResponeToken(String token, String roles, String id_User) {
        this.token = token;
        this.roles = roles;
        this.id_User = id_User;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getId_User() {
        return id_User;
    }

    public void setId_User(String id_User) {
        this.id_User = id_User;
    }
}
