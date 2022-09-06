package com.example.ramsha.mehmood.quranapprecyclerview;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteAssetHelper {
    public static final String DBNAME = "quran_database.db";
    public static final int DBVERSION = 1;
    public static final String TNAME = "tayah";

    public DBHelper(Context context) {
        super(context,DBNAME,null,DBVERSION);
    }
    int id = 1;
    public ArrayList<ModelClass> getData(String ColName,int Suranum) {
        SQLiteDatabase db = this.getReadableDatabase();
      //  SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        Cursor cursorCourses = db.rawQuery("SELECT "+"'"+ ColName+"'"+ " FROM " + TNAME +" WHERE SuraID = " + "'"+Suranum +"'" , null);
        Log.d("data","In cursor1"+cursorCourses);

        ArrayList<ModelClass> data = new ArrayList<>();
        Log.d("data","In cursor0");

        if (cursorCourses.moveToFirst()) {
            Log.d("data","In cursor1");
            do {
                data.add(new ModelClass(
                        cursorCourses.getInt(0),
                        cursorCourses.getInt(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(7),
                        cursorCourses.getInt(8),
                        cursorCourses.getInt(9),
                        cursorCourses.getInt(10),
                        cursorCourses.getString(11)
                       ));
                Log.d("data","In cursor2");
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data;
    }
}