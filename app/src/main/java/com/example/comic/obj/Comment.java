package com.example.comic.obj;

public class Comment {
    private User user;
    private String content;

    public Comment(){}

    public Comment(User user,String content){
        this.user = user;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }
}
