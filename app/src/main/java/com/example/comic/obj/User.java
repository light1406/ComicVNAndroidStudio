package com.example.comic.obj;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String avatar;

    public User() {}

    public User(int id, String username, String password, String name, String avatar){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
