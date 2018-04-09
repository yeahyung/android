package com.example.yea.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText URL;
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL = findViewById(R.id.editText);
        nextBtn = findViewById(R.id.NEXTbtn);
        nextBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String myURL = URL.getText().toString();
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("url",myURL);
                startActivity(intent);
            }
        });
    }
}
