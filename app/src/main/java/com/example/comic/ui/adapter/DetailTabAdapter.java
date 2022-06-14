package com.example.comic.ui.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.comic.obj.Chapter;
import com.example.comic.ui.fragment.ChapterFragment;
import com.example.comic.ui.fragment.ContentFragment;

import java.util.List;

public class DetailTabAdapter extends FragmentStateAdapter {

    private List<Chapter> chapterList;
    private String content;
    private int comicId;

    public DetailTabAdapter(@NonNull FragmentActivity fragmentActivity,
                            int comicId,List<Chapter> chapterList, String content) {
        super(fragmentActivity);
        this.comicId = comicId;
        this.chapterList = chapterList;
        this.content = content;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ChapterFragment(comicId,chapterList);
            case 1:
                return new ContentFragment(content);
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
