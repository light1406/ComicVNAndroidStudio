package com.example.comic.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.comic.R;
import com.example.comic.dao.ComicDao;
import com.example.comic.obj.Chapter;
import com.example.comic.obj.Comic;
import com.example.comic.obj.ComicImage;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.tool_bar));

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.home_fragment)
                .setOpenableLayout(findViewById(R.id.drawer))
                .build();
        controller = Navigation.findNavController(this, R.id.nav_control);
        NavigationView navigationView = findViewById(R.id.nav);
        NavigationUI.setupActionBarWithNavController(this, controller, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(controller, appBarConfiguration);
    }
}