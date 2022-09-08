package com.example.ramsha.mehmood.quranapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class English extends AppCompatActivity {
    ListView listview;
    QDH data = new QDH();
    ArrayList<ListModel> list = new ArrayList<>();
    String Req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        listview = findViewById(R.id.ERV);
        Intent intent = getIntent();
        Req = intent.getStringExtra("required");
        String[] data2 = data.getEnglishSurahNames();
        for (int i = 0; i < data2.length; i++) {
            int j = i + 1;
            list.add(new ListModel(data2[i], j));
        }
        RecyclerViewAdapterEnglish adapter = new RecyclerViewAdapterEnglish(getBaseContext(), list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListModel item =  (ListModel) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(view.getContext(), ShowText.class);
                intent.putExtra("SurahNum", item.SurahNum);
                intent.putExtra("Required", Req);
                startActivity(intent);
            }
        });
    }
}






