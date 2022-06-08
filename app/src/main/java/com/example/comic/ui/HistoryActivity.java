package com.example.comic.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.comic.R;
import com.example.comic.adapter.HistoryAdapter;
import com.example.comic.obj.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;
    private List<History> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //khoi tao
        recyclerView = findViewById(R.id.rv_history);
        historyAdapter = new HistoryAdapter();
        list = new ArrayList<>();

        // tao layout
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        loadData();
        recyclerView.setAdapter(historyAdapter);

    }

    private void loadData() {
        list = getList();
        historyAdapter.setData(list);
    }


    private List<History> getList() {
        List<History> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new History(500, "One piece", "state"));
        }

        return list;
    }
}