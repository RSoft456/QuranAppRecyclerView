package com.example.ramsha.mehmood.quranapprecyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterEnglish extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ListModel> EnglishSurahNames = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surahnameview, parent, false);
        return new RecyclerViewAdapterEnglish.EnglishSurahVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListModel item = EnglishSurahNames.get(position);
        RecyclerViewAdapterEnglish.EnglishSurahVH ViewHolder = (RecyclerViewAdapterEnglish.EnglishSurahVH) holder;
        ViewHolder.Text.setText(item.getSurahName());
        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShowText.class);
                intent.putExtra("SurahNum",item.SurahNum);
                view.getContext().startActivity(intent);
            }
        });

    }

    public void setData(ArrayList<ListModel> EnglishSurahNames) {
        this.EnglishSurahNames = EnglishSurahNames;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return EnglishSurahNames.size();
    }


    public static class EnglishSurahVH extends RecyclerView.ViewHolder {
        TextView Text;

        public EnglishSurahVH(@NonNull View itemView) {
            super(itemView);
            Text = itemView.findViewById(R.id.RVText);

        }
    }
}

