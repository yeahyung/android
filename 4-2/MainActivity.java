package com.example.yea.lab4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    Button button,button1;
    LinearLayout layout,layout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button1=findViewById(R.id.button1);

        layout=findViewById(R.id.layout);
        layout1=findViewById(R.id.layout1);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);
                layout1.setVisibility(VISIBLE);
                layout1.startAnimation(anim);

            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
                layout1.startAnimation(anim);
                layout1.setVisibility(GONE);

            }
        });
    }
}

