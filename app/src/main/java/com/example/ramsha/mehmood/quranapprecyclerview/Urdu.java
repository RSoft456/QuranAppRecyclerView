package com.example.ramsha.mehmood.quranapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class Urdu extends AppCompatActivity {
    RecyclerView recycleview;
    QDH data = new QDH();
    ArrayList<ListModel> list = new ArrayList<>();
    String Req;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu);
        recycleview = findViewById(R.id.URV);
        Intent intent = getIntent();
        Req= intent.getStringExtra("required");
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerViewAdapterUrdu RVadapter = new RecyclerViewAdapterUrdu(Req);
        recycleview.setAdapter(RVadapter);
//        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setLayoutManager(new GridLayoutManager(this, 3));
        String[] data2 = data.getUrduSurahNames();
        for (int i = 0; i < data2.length; i++) {
            int j=i+1;
            list.add(new ListModel(data2[i],j));
        }
        RVadapter.setData(list);

    }
}