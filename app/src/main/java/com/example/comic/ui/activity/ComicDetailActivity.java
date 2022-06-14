package com.example.comic.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.comic.R;
import com.example.comic.dao.ComicDao;
import com.example.comic.obj.Comic;
import com.example.comic.ui.adapter.CategoryAdapter;
import com.example.comic.ui.adapter.DetailTabAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ComicDetailActivity extends AppCompatActivity {
    private TextView comicNameView, comicStateView, comicViewNumberView;
    private RecyclerView categoryView;//danh sach the loai
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private DetailTabAdapter detailTabAdapter;
    private Comic comic;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_detail_activity);
        context = this;
        initView();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        loadData();
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

    private void initView(){
        comicNameView = findViewById(R.id.comic_name);
        comicStateView = findViewById(R.id.comic_state);
        comicViewNumberView = findViewById(R.id.view_number);
        categoryView = findViewById(R.id.category_comic);
        categoryView.setLayoutManager(new GridLayoutManager(this, 3));
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.pager);
    }

    public void loadData(){
        int comicId = getIntent().getIntExtra("COMICID", -1);

        Query query = ComicDao.getInstance().getComic(comicId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                comic = snapshot.getValue(Comic.class);
                comicNameView.setText(comic.getName());
                comicStateView.setText(comic.getState());
                comicViewNumberView.setText(comic.getView() + "");
                categoryView.setAdapter(new CategoryAdapter(comic.getCategory()));
                //tab
                detailTabAdapter = new DetailTabAdapter((FragmentActivity) context,
                        comic.getChapters(), comic.getContent());
                viewPager2.setAdapter(detailTabAdapter);
                new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
                    String[] title = {"Chapter", "Nội dung"};
                    tab.setText(title[position]);
                }).attach();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
