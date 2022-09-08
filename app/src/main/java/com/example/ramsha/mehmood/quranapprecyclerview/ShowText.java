package com.example.ramsha.mehmood.quranapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class ShowText extends AppCompatActivity {
    TextView text,heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);
        text = findViewById(R.id.SuraText);
        heading=findViewById(R.id.SuraNametxt);
        heading.setTypeface(ResourcesCompat.getFont(this, R.font.noorehuda));
        text.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();
        String Require = intent.getStringExtra("Required");
        Log.d("val","val "+Require);
        int num = intent.getIntExtra("SurahNum", 0);
        String Name = intent.getStringExtra("SuraName");
        heading.setText(Name);
        DBHelper db = new DBHelper(this);
        List<ModelClass> data2 = db.getData(Require, num);
//        Log.d("data", "this is data " + data2.get(i).SuraId);
        String data = "";
        String data1="";
        if(num != 1 ) {
            data = "-   بِسۡمِ اللّٰہِ الرَّحۡمٰنِ الرَّحِیۡمِ \n";
            data1="*  In the Name of Allah, the Most Beneficient, the Most Merciful.\n";
        }
        for (int i = 0; i < data2.size(); i++) {

            switch (Require) {
                case "Arabic_Text":
                    data = data + data2.get(i).ArabicText + "\n" ;
                    break;
                case "Fateh_Muhammad_Jalandhri":
                    data = data + "*  " + data2.get(i).Fateh_Muhammad_Jalandhri+ "\n" ;
                    break;
                case "Mehmood_ul_Hassan":
                    data = data + "*  " + data2.get(i).Mehmood_ul_Hassan+ "\n" ;
                    break;
                case "Dr_Mohsin_Khan":
                    data1 = data1 + "*  " + data2.get(i).Dr_Mohsin_Khan+ "\n" ;
                    break;
                case "Mufti_Taqi_Usmani":
                    data1 = data1 +"*  " + data2.get(i).Mufti_Taqi_Usmani+ "\n" ;
                    break;
                default:
                    data = "No data Against this Suarah present";
                    break;
            }
        }
        if(Require.equals("Arabic_Text"))
            text.setTypeface(ResourcesCompat.getFont(this, R.font.noorehuda));
        else
            text.setTypeface(ResourcesCompat.getFont(this, R.font.jameelnoorinastaleeq));
        switch (Require) {
            case "Arabic_Text":
                text.setText(data);
                break;
            case "Fateh_Muhammad_Jalandhri":
                text.setText(data);
                break;
            case "Mehmood_ul_Hassan":
                text.setText(data);
                break;
            case "Dr_Mohsin_Khan":
                text.setText(data1);
                break;
            case "Mufti_Taqi_Usmani":
                text.setText(data1);
                break;
            default:
                text.setText("No data");
                break;
        }
    }
}