package com.example.comic.service;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;

import java.text.BreakIterator;

public class HistoryVH extends RecyclerView.ViewHolder {
    public TextView txtName, txtState;
    public ImageView imageView;
    public Button btnDelete;

    public HistoryVH(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txt_name);
        txtState = itemView.findViewById(R.id.txt_state);
        imageView = itemView.findViewById(R.id.iv_avatar);
//        btnDelete = itemView.findViewById(R.id.btn_delete_history);
    }
}
