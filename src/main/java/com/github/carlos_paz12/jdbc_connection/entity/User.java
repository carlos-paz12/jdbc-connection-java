package com.github.carlos_paz12.jdbc_connection.entity;

public class User {

    private Long id;
    private String email;
    private String password;

    public User() {
    }

    public User(Long id, String email, String password) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
