package com.example.yea.lab6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    public void onCreate(SQLiteDatabase db){
        String sql = "create table student (" +
                "name text, " +
                "studentNo text);";
        db.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        String sql = "drop table if exists student";
        db.execSQL(sql);
        onCreate(db);
    }
}