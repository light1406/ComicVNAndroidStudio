package com.example.comic.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.comic.R;

public class ContentFragment extends Fragment {

    private String content;

    public ContentFragment (String content){
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comic_content_fragment, container, false);
        TextView textView = view.findViewById(R.id.content_comic);
        textView.setText(content);
        return view;
    }
}
