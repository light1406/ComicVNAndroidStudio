package com.example.comic.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.obj.Comic;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewUpdateAdapter extends RecyclerView.Adapter<NewUpdateAdapter.NewUpdateHolder> {

    private List<Comic> newUpdateList;

    public NewUpdateAdapter(List<Comic> newUpdateList){
        this.newUpdateList = newUpdateList;
    }

    @NonNull
    @Override
    public NewUpdateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comic_main_card, parent, false);
        return new NewUpdateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewUpdateHolder holder, int position) {
        holder.comicName.setText(newUpdateList.get(position).getName());
        Picasso.get()
                .load(newUpdateList.get(position).getCover())
                .fit()
                .into(holder.comicImage);
    }

    @Override
    public int getItemCount() {
        return newUpdateList != null ? newUpdateList.size() : 0;
    }

    public class NewUpdateHolder extends RecyclerView.ViewHolder {

        private ImageView comicImage;
        private TextView comicName;

        public NewUpdateHolder(@NonNull View itemView) {
            super(itemView);
            comicImage = itemView.findViewById(R.id.comic_image);
            comicName = itemView.findViewById(R.id.comic_name_label_nu);
        }
    }
}
