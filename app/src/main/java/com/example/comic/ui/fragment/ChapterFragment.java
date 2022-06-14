package com.example.comic.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.obj.Chapter;
import com.example.comic.ui.adapter.ChapterAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterFragment extends Fragment {

    private RecyclerView chaptersView;
    private ChapterAdapter chapterAdapter;
    private List<Chapter> chapterList;

    public ChapterFragment(List<Chapter> chapterList){
        this.chapterList = chapterList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chapters_fragment, container, false);
        chaptersView = view.findViewById(R.id.chapter_list_view);
        chaptersView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        chapterAdapter = new ChapterAdapter(chapterList);
        chaptersView.setAdapter(chapterAdapter);
        return view;
    }
}
