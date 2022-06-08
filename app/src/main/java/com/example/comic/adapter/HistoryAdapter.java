package com.example.comic.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.obj.History;
import com.example.comic.service.HistoryVH;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryVH> {
    private List<History> list;

    public void setData(List<History> items) {
        this.list = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryVH holder, int position) {
        History his = list.get(position);
        if (his != null) {
            holder.txtName.setText(his.getName());
            holder.txtState.setText(his.getNumberChapter());
            holder.imageView.setImageDrawable(Drawable.createFromPath(his.getUrl()));
        }
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }
}
