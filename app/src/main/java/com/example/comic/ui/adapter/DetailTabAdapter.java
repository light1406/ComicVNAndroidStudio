package com.example.comic.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.comic.ui.fragment.ChapterFragment;
import com.example.comic.ui.fragment.ContentFragment;

public class DetailTabAdapter extends FragmentStateAdapter {

    public DetailTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ChapterFragment();
            case 1:
                return new ContentFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
