package com.example.comic.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.comic.R;
import com.example.comic.dao.ComicDao;
import com.example.comic.obj.Chapter;
import com.example.comic.obj.Comic;
import com.example.comic.obj.ComicImage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}