package com.example.consocio.bibliospaz.Models;

public class Login {
    private String email;
    private String password;
    private String access_token;
    private Integer expires_in;
    private String name;
    private String surname;
    private Boolean success;
    private String msg;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessToken() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
