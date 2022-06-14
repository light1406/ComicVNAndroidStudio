package com.example.comic.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.obj.Chapter;
import com.example.comic.ui.activity.ChapterActivity;

import java.util.List;

public class DetailChapterAdapter extends RecyclerView.Adapter<DetailChapterAdapter.ChapterHolder> {

    private int comicId;
    private List<Chapter> chapterList;
    private Context context;

    public DetailChapterAdapter(int comicId,List<Chapter> chapterList, Context context){
        this.comicId = comicId;
        this.chapterList = chapterList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chapter_card, parent, false);
        return new ChapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.chapterNumber.setText("Chapter " + chapterList.get(position).getNumber());
        holder.chapterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChapterActivity.class);
                intent.putExtra("COMICID", comicId);
                intent.putExtra("CHAPTER", chapterList.get(position).getNumber());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapterList != null ? chapterList.size() : 0;
    }

    public class ChapterHolder extends RecyclerView.ViewHolder {

        private TextView chapterNumber, chapterUpdateDate;
        private CardView chapterCard;

        public ChapterHolder(@NonNull View itemView) {
            super(itemView);
            chapterNumber = itemView.findViewById(R.id.number_chapter);
            chapterUpdateDate = itemView.findViewById(R.id.chapter_update_date);
            chapterCard = itemView.findViewById(R.id.chapter_card);
        }
    }
}
