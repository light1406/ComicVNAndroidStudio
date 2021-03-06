package com.example.comic.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comic.R;
import com.example.comic.dao.ComicDao;
import com.example.comic.obj.Comic;
import com.example.comic.ui.activity.MainActivity;
import com.example.comic.ui.adapter.ForYouAdapter;
import com.example.comic.ui.adapter.NewUpdateAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView forYouListView, newUpdateListView;

    private ForYouAdapter forYouAdapter;
    private NewUpdateAdapter newUpdateAdapter;

    private List<Comic> forYouList, newUpdateList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.home_fragment, container, false);
        setUpForYouLayout();
        setUpNewUpdateLayout();

        return view;
    }

    public void setUpForYouLayout(){
        forYouListView = view.findViewById(R.id.for_you_list);
        forYouListView.setLayoutManager(new LinearLayoutManager(view.getContext()
                , RecyclerView.HORIZONTAL, false));
        forYouList = new ArrayList<>();
        forYouAdapter = new ForYouAdapter(forYouList);
        forYouListView.setAdapter(forYouAdapter);
        forYouListView.smoothScrollBy(5,0);
        loadDataForYou();
        autoScollSlide();
    }

    public void setUpNewUpdateLayout(){
        newUpdateListView = view.findViewById(R.id.new_update_list);
        newUpdateListView.setLayoutManager(new GridLayoutManager(view.getContext()
                , 2));
        newUpdateListView.setNestedScrollingEnabled(false);
        newUpdateList = new ArrayList<>();
        newUpdateAdapter = new NewUpdateAdapter(newUpdateList, getContext());
        newUpdateListView.setAdapter(newUpdateAdapter);
        loadDataNewUpdate();
    }

    private void loadDataNewUpdate(){
        Query query = ComicDao.getInstance().getForYouComics();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot post: snapshot.getChildren()){
                    Comic comic = post.getValue(Comic.class);
                    for (int i =0 ; i < 10; i++){
                        newUpdateList.add(comic);
                    }
                }
                newUpdateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(view.getContext()
                        , "???? c?? chuy???n g?? ???? kh??ng ???n x???y ra", Toast.LENGTH_SHORT ).show();
            }
        });
    }

    private void loadDataForYou(){
        Query query = ComicDao.getInstance().getForYouComics();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot post: snapshot.getChildren()){
                    Comic comic = post.getValue(Comic.class);
                    for (int i =0 ; i < 6; i++){
                        forYouList.add(comic);
                    }
                }
                forYouAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(view.getContext()
                        , "???? c?? chuy???n g?? ???? kh??ng ???n x???y ra", Toast.LENGTH_SHORT ).show();
            }
        });
    }

    private void autoScollSlide(){
        new CountDownTimer(60000, 1500) {
            int current = 0;
            @Override
            public void onTick(long l) {
                if (current < forYouList.size()){
                    forYouListView.scrollToPosition(current++);
                }else{
                    current = 0;
                }
            }
            @Override
            public void onFinish() {}
        }.start();
    }
}
