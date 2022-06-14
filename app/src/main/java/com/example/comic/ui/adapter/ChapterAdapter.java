package com.example.comic.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.obj.Chapter;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterHolder> {

    private List<Chapter> chapterList;

    public ChapterAdapter(List<Chapter> chapterList){
        this.chapterList = chapterList;
    }

    @NonNull
    @Override
    public ChapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chapter_card, parent, false);
        return new ChapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterHolder holder, int position) {
        holder.chapterNumber.setText("Chapter " + chapterList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return chapterList != null ? chapterList.size() : 0;
    }

    public class ChapterHolder extends RecyclerView.ViewHolder {

        private TextView chapterNumber, chapterUpdateDate;

        public ChapterHolder(@NonNull View itemView) {
            super(itemView);
            chapterNumber = itemView.findViewById(R.id.number_chapter);
            chapterUpdateDate = itemView.findViewById(R.id.chapter_update_date);
        }
    }
}
