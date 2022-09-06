package com.example.ramsha.mehmood.quranapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class English extends AppCompatActivity {
    RecyclerView recycleview;
    QDH data = new QDH();
    ArrayList<ListModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        recycleview = findViewById(R.id.ERV);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerViewAdapterEnglish RVadapter = new RecyclerViewAdapterEnglish();
        recycleview.setAdapter(RVadapter);
//      recycleview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setLayoutManager(new GridLayoutManager(this, 3));

        String[] data2 = data.getEnglishSurahNames();
        for (int i = 0; i < data2.length; i++) {
            int j = i + 1;
            list.add(new ListModel(data2[i], j));
        }
        RVadapter.setData(list);

    }
}