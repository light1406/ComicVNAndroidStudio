package com.example.comic.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.dao.ComicDao;
import com.example.comic.obj.Comic;
import com.example.comic.obj.ComicImage;
import com.example.comic.ui.adapter.ChapterPageAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChapterActivity extends AppCompatActivity {
    private RecyclerView pageView;
    private int comicId, chapter;
    private List<ComicImage> comicImages;
    private ChapterPageAdapter chapterPageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_activity);

        pageView = findViewById(R.id.image_list_chapter);
        pageView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        pageView.setNestedScrollingEnabled(false);
        comicId = getIntent().getIntExtra("COMICID", -1);
        chapter = getIntent().getIntExtra("CHAPTER", -1);
        comicImages = new ArrayList<>();
        chapterPageAdapter = new ChapterPageAdapter(comicImages);
        pageView.setAdapter(chapterPageAdapter);
        loadData();
    }

    private void loadData(){
        Query query = ComicDao.getInstance().getChapter(comicId, chapter);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot post: snapshot.getChildren()){
                    ComicImage comicImage = post.getValue(ComicImage.class);
                    comicImages.add(comicImage);
                }
                chapterPageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
