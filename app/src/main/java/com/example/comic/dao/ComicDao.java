package com.example.comic.dao;

import androidx.annotation.NonNull;

import com.example.comic.obj.Comic;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ComicDao {

    private DatabaseReference comicDb;

    private static ComicDao comicDao;

    private ComicDao(){
        comicDb = FirebaseDatabase.getInstance().getReference("comics");
    }

    public static ComicDao getInstance(){
        if (comicDao == null){
            comicDao = new ComicDao();
        }
        return comicDao;
    }

    public Task<Void> saveComic(Comic comic){
        return comicDb.child(String.valueOf(comic.getId())).setValue(comic);
    }

    public Query getForYouComics(){
        Query fycmQuery = comicDb;
        return fycmQuery;
    }

    public Query getNewUpdateComics(){
        Query newUpdateComics = comicDb;
        return newUpdateComics;
    }

    public Query getComic(int id){
        return comicDb.child(id +"");
    }

    public Query getChapter(int comicId, int chapter){
        return comicDb.child(comicId + "/chapters/" + chapter + "/imageList");
    }
}
