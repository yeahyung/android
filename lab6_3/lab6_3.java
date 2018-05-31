package com.example.yea.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class lab6_3 extends AppCompatActivity {
ListView list;
String[] info;
SQLiteDatabase db;
MySQLiteOpenHelper helper;
EditText namee,getSN;
Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_3);
        helper = new MySQLiteOpenHelper(lab6_3.this,"student.db",null,1);
        list = findViewById(R.id.list);
        namee=findViewById(R.id.name);
        getSN = findViewById(R.id.getSN);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() { // 추가
            @Override
            public void onClick(View view) {
                String msg1, msg2;
                msg1 = namee.getText().toString();
                msg2 = getSN.getText().toString();
                if (msg1.length() == 0 || msg2.length() == 0)
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
                else {
                    insert(msg1, msg2);
                    invalidate();
                    Toast.makeText(getApplicationContext(), "Insert 성공", Toast.LENGTH_SHORT).show();
                    namee.setText("");
                    getSN.setText("");
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() { // 삭제
            @Override
            public void onClick(View view) {
                String msg1 = namee.getText().toString();
                if(msg1.length()==0)
                    Toast.makeText(getApplicationContext(),"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();
                else{
                    delete(msg1);
                    Toast.makeText(getApplicationContext(),"Delete 성공.",Toast.LENGTH_SHORT).show();
                    invalidate();
                    namee.setText("");
                    getSN.setText("");
                }
            }
        });
    }
    public void insert(String name,String stunum){
        db=helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("studentNo",stunum);
        db.insert("student",null,values);
    }
    public void delete(String name){
        db=helper.getWritableDatabase();
        db.delete("student","name=?",new String[]{name});
    }
    public void select(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("student",null,null,null,null,null,null);
        info = new String[c.getCount()];
        int count=0;
        while(c.moveToNext()){
            info[count] = c.getString(c.getColumnIndex("name")) + " " + c.getString(c.getColumnIndex("studentNo"));
            count++;
        }
        c.close();
    }
    public void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,info);
        list.setAdapter(adapter);
    }
}
