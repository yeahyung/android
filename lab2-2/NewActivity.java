package com.example.yea.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView textView;
    Button goBtn;
    Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = findViewById(R.id.textbtn);
        goBtn = findViewById(R.id.Gobutton);
        backBtn = findViewById(R.id.Backbutton);

        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("url");
        textView.setText(passedUrl);
        goBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (passedUrl.length() != 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + passedUrl));
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요",Toast.LENGTH_LONG).show();
                }

            }});
        backBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
