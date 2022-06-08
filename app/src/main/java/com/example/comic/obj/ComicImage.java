package com.example.comic.obj;

public class ComicImage {
    private int numberPage;
    private String url;

    public ComicImage(){}

    public ComicImage(int numberPage,String url){
        this.numberPage = numberPage;
        this.url = url;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public String getUrl() {
        return url;
    }
}
