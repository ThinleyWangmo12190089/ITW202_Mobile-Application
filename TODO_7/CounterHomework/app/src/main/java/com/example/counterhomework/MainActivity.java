package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int number;
    private TextView Count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Count = findViewById(R.id.Text_View);
        Button c_btn = findViewById(R.id.count_btn);

        if (savedInstanceState != null){
            number = savedInstanceState.getInt("count_no");
            Count.setText(String.valueOf(number));
        }
    }

    public void COUNT(View view) {
        number++;
        Count.setText(""+number);
    }

    @Override
    protected void onSaveInstanceState(@NorNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_no", number);
    }
}