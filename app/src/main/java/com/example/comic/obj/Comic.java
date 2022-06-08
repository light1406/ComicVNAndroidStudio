package com.example.comic.obj;

import java.util.Date;
import java.util.List;

public class Comic {
    private int id;
    private String name;
    private String cover;
    private String state;
    private List<String> category;
    private long view;
    private long like;
    private String content;
    private List<Chapter> chapters;
    private List<Comment> comments;

    public Comic(){}

    public Comic(int id, String name, String cover, String state
            , List<String> category, long view, long like, String content
            , List<Chapter> chapters, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.state = state;
        this.category = category;
        this.view = view;
        this.like = like;
        this.content = content;
        this.chapters = chapters;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public String getCover() {
        return cover;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<String> getCategory() {
        return category;
    }

    public long getLike() {
        return like;
    }

    public long getView() {
        return view;
    }

    public String getContent() {
        return content;
    }

    public String getState() {
        return state;
    }
}
