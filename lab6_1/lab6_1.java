package com.example.yea.lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;

public class lab6_1 extends AppCompatActivity {
EditText txt;
Button btn1,btn2,btn3,btn4;
String path;
File directory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.txtData);
        btn1=findViewById(R.id.write);
        btn2=findViewById(R.id.clear);
        btn3=findViewById(R.id.read);
        btn4=findViewById(R.id.finish);
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        directory = new File(path+"/MyFiles");
        directory.mkdirs();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = txt.getText().toString();
                try{
                    File f = new File(directory,"external.txt");
                  OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
                    writer.append(data);
                    writer.close();
                    Toast.makeText(getApplicationContext(),"Done writing SD myexternal.txt", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"fail to write",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    File f = new File(directory,"external.txt");
                   Reader reader = new FileReader(f);
                   BufferedReader buffer = new BufferedReader(reader);
                   String str = buffer.readLine();
                   while(str!=null){
                       txt.append(str+"\n");
                       str=buffer.readLine();
                   }
                   buffer.close();
                   reader.close();
                    Toast.makeText(getApplicationContext(),"Done reading SD myexternal.txt", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"fail to read",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
