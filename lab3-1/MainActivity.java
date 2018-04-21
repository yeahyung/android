package com.example.yea2.hello;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button contextBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextBtn = findViewById(R.id.btn);
        registerForContextMenu(contextBtn);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("Button Menu");
        menu.add(0,0,0,"Red");
        menu.add(0,1,1,"Green");
        menu.add(0,2,2,"Blue");
    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()== 0)
            contextBtn.setTextColor(Color.RED);
        if(item.getItemId()== 1)
            contextBtn.setTextColor(Color.GREEN);
        if(item.getItemId()== 2)
            contextBtn.setTextColor(Color.BLUE);
        return true;
    }
}
