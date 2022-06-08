package com.example.comic.obj;

import java.util.List;

public class Chapter {
    private int number;
    private List<ComicImage> imageList;

    public Chapter() {}

    public Chapter(int number, List<ComicImage> imageList){
        this.number = number;
        this.imageList = imageList;
    }

    public int getNumber() {
        return number;
    }

    public List<ComicImage> getImageList() {
        return imageList;
    }
}
