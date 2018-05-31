package com.example.yea.lab6;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class lab6_2 extends AppCompatActivity {
EditText sn,name;
String stunum,stuname;
Button btn1,btn2,btn3;
SharedPreferences sh_pref;
SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_2);
        sn = findViewById(R.id.sn);
        name = findViewById(R.id.name);
        btn1=findViewById(R.id.call);
        btn2=findViewById(R.id.save);
        btn3=findViewById(R.id.initialize);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stunum=sn.getText().toString();
                stuname=name.getText().toString();
                sharedPreferences();
                Toast.makeText(getApplicationContext(),"Details are saved", Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sn.setText("");
                name.setText("");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applySharedPreference();
            }
        });
    }

    public void sharedPreferences(){
        sh_pref = getSharedPreferences("Login Credentials",MODE_PRIVATE);
        toEdit=sh_pref.edit();
        toEdit.putString("StudentNumber",stunum);
        toEdit.putString("StudentName",stuname);
        toEdit.commit();
    }
    public void applySharedPreference(){
        sh_pref=getSharedPreferences("Login Credentials",MODE_PRIVATE);
        if(sh_pref!=null && sh_pref.contains("StudentNumber")){
            String number = sh_pref.getString("StudentNumber","0");
            sn.setText(number);
            String tempname = sh_pref.getString("StudentName","noname");
            name.setText(tempname);
        }
    }
}
