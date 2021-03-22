package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int i = 0;
    Button btno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Toast(View v){
        Toast t = Toast.makeText(this, "Hello Toast!",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 200);
        t.show();
    }
    public void count(View v){
        i++;
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(""+i);
    }
}