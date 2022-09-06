package com.example.ramsha.mehmood.quranapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class ShowText extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);
        text = findViewById(R.id.SuraText);
        Intent intent = getIntent();
        String Require = intent.getStringExtra("Required");
        Log.d("val","val "+Require);
        int num = intent.getIntExtra("SurahNum", 0);
        DBHelper db = new DBHelper(this);
        List<ModelClass> data2 = db.getData(Require, num);
//        Log.d("data", "this is data " + data2.get(i).SuraId);
        String data = null;
        for (int i = 0; i < data2.size(); i++) {
            switch (Require) {
                case "Arabic_Text":
                    data = data + " " + data2.get(i).ArabicText;
                    break;
                case "Fateh_Muhammad_Jalandhri":
                    data = data + " " + data2.get(i).Fateh_Muhammad_Jalandhri;
                    break;
                case "Mehmood_ul_Hassan":
                    data = data + " " + data2.get(i).Mehmood_ul_Hassan;
                    break;
                case "Dr_Mohsin_Khan":
                    data = data + " " + data2.get(i).Dr_Mohsin_Khan;
                    break;
                case "Mufti_Taqi_Usmani":
                    data = data + " " + data2.get(i).Mufti_Taqi_Usmani;
                    break;
                default:
                    data = "No data Against this Suarah present";
                    break;
            }
        }
        text.setText(data);
    }
}