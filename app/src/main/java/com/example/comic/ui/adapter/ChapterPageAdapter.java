package com.example.comic.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.obj.ComicImage;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChapterPageAdapter extends RecyclerView.Adapter<ChapterPageAdapter.PageHodler> {
    private List<ComicImage> pageImg;

    public ChapterPageAdapter(List<ComicImage> pageImg){
        this.pageImg = pageImg;
    }

    @NonNull
    @Override
    public PageHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_card, parent, false);
        return new PageHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageHodler holder, int position) {
        Picasso.get().load(pageImg.get(position).getUrl())
                .into(holder.page);
    }

    @Override
    public int getItemCount() {
        return pageImg != null ? pageImg.size() : 0;
    }

    public class PageHodler extends RecyclerView.ViewHolder {
        private ImageView page;
        public PageHodler(@NonNull View itemView) {
            super(itemView);
            page = itemView.findViewById(R.id.page_image);
        }
    }
}
