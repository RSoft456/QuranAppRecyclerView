package com.example.ramsha.mehmood.quranapprecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    TextView data;
    Intent intent;

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        data=findViewById(R.id.textviewdata);
        DBHelper db = new DBHelper(this);
        List<ModelClass> data2 = db.getData();
        for(int i=0 ;i<data2.size();i++ ){
            Log.d("data","this is data "+ data2.get(i).SuraId);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ReadQuran:
                        intent = new Intent(MainActivity3.this, Urdu.class);
                        intent.putExtra("required","ReadQuran");
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.UrduFMJ:
                        intent = new Intent(MainActivity3.this, Urdu.class);
                        intent.putExtra("required","UrduFMJ");
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.UrduMUH:
                        intent = new Intent(MainActivity3.this, Urdu.class);
                        intent.putExtra("required","UrduMUH");
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.EnglishDMK:
                        intent = new Intent(MainActivity3.this, English.class);
                        intent.putExtra("required","EnglishDMK");
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.EnglishMTU:
                        intent = new Intent(MainActivity3.this, English.class);
                        intent.putExtra("required","EnglishMTU");
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });


    }
}



