package com.example.comic.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.comic.R;
import com.example.comic.ui.adapter.CategoryAdapter;
import com.example.comic.ui.adapter.DetailTabAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ComicDetailActivity extends AppCompatActivity {

    private RecyclerView category;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private DetailTabAdapter detailTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_detail);

        category = findViewById(R.id.category_comic);
        category.setLayoutManager(new GridLayoutManager(this, 3));
        List<String> categoryList = new ArrayList<>();
        categoryList.add("Chuyển sinh");
        categoryList.add("Manhua");

        category.setAdapter(new CategoryAdapter(categoryList));

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.pager);

        detailTabAdapter = new DetailTabAdapter(this);
        viewPager2.setAdapter(detailTabAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            String[] title = {"Chapter", "Nội dung"};
            tab.setText(title[position]);
        }).attach();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
