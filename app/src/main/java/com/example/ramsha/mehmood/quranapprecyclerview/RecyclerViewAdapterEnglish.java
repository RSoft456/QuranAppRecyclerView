package com.example.ramsha.mehmood.quranapprecyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class RecyclerViewAdapterEnglish extends ArrayAdapter<ListModel> {



    public RecyclerViewAdapterEnglish(@NonNull Context context, ArrayList<ListModel> ListViewArray) {
        super(context, R.layout.surahnameview, ListViewArray);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ListModel list = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surahnameview, parent, false);
        TextView Text = convertView.findViewById(R.id.RVText);
        Text.setText(list.getSurahName());

        return convertView;
    }
}


