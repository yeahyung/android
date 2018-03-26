package com.example.yea2.hello;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        edit_name=(EditText)findViewById(R.id.Edit);
        btn_print=(Button)findViewById(R.id.Print);
        btn_clear=(Button)findViewById(R.id.Clear);
        view_print=(TextView)findViewById(R.id.contents);
    }

    public void clearClicked(View v){
        edit_name.setText("");
        view_print.setText("");
    }
    public void printClicked(View v){
        String text="";
       text=edit_name.getText().toString();
       view_print.setText(text);
    }
}
