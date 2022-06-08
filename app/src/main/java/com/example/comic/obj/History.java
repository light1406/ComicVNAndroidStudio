package com.example.comic.obj;

public class History {
    private int numberChapter;
    private String name;
    private String url;

    public History(int numberChapter, String name, String url) {
        this.numberChapter = numberChapter;
        this.name = name;
        this.url = url;
    }

    public int getNumberChapter() {
        return numberChapter;
    }

    public void setNumberChapter(int numberChapter) {
        this.numberChapter = numberChapter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
