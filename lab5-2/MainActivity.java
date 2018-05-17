package com.example.yea.lab5;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView textView;
EditText editText;
Button button;
Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Calculate().execute();
            }
        });
    }

    private class Calculate extends AsyncTask<Void, Integer, Void> {
        int result = 1;
        protected void onPreExecute(){
            textView.setText(" ");
        }
        protected Void doInBackground(Void... params) {
            String num = editText.getText().toString();
            for (int i = Integer.parseInt(num); i >= 1; i--) {
                try {
                    Thread.sleep(500);
                    publishProgress(i);
                    result = result * i;
                } catch (Exception e) {
                }
             }
            return null;
        }
        protected void onProgressUpdate(Integer... values){
            textView.append(values[0].intValue()+ " ");
        }
        protected void onPostExecute(Void aVoid){
            textView.append("\n = " + result);
        }
    }
}
