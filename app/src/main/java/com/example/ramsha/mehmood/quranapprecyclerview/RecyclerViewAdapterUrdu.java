package com.example.ramsha.mehmood.quranapprecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterUrdu extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ListModel> UrduSurahNames = new ArrayList<>();
    String req;

    RecyclerViewAdapterUrdu(String req) {
        this.req = req;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surahnameview, parent, false);
        return new RecyclerViewAdapterUrdu.UrduSurahVH(view);
    }
    public void setData(ArrayList<ListModel> UrduSurahNames) {
        this.UrduSurahNames = UrduSurahNames;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ListModel item = UrduSurahNames.get(position);
        RecyclerViewAdapterUrdu.UrduSurahVH ViewHolder = (RecyclerViewAdapterUrdu.UrduSurahVH) holder;
        ViewHolder.Text.setText(item.getSurahName());
        ViewHolder.Text.setTypeface(ResourcesCompat.getFont(ViewHolder.context, R.font.noorehuda));

        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShowText.class);
                intent.putExtra("SurahNum",item.SurahNum);
                intent.putExtra("Required",req);
                intent.putExtra("SuraName",item.getSurahName());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return UrduSurahNames.size();
    }


    public static class UrduSurahVH extends RecyclerView.ViewHolder {
        TextView Text;
        Context context;


        public UrduSurahVH(@NonNull View itemView) {
            super(itemView);
            Text = itemView.findViewById(R.id.RVText);
            context=itemView.getContext();
        }
    }
}

