package com.example.consocio.bibliospaz.Utils;

import retrofit2.http.POST;

public class Login {
    private String email;
    private String password;
    private String access_token;
    private Integer expires_in;
    private String name;
    private String surname;
    private String success;
    private String msg;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getSuccess() {
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

    public String getAccess_token() {
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
