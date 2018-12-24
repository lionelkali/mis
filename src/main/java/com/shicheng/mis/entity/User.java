package com.shicheng.mis.entity;

public class User {
    private Integer id;
    private String name;
    private String password;


    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
