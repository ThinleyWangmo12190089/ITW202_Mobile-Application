package com.example.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textViewHello;
    private String[] colorArr ={"purple_200","purple_500","purple_700","teal_200","teal_700","black","neon","pink","redish","orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHello = findViewById(R.id.textV_Hello);

    }

    public void color(View view) {
        Random random = new Random();
        String colorName = colorArr[random.nextInt(10)];

        int colorRName = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorRName);
        textViewHello.setTextColor(colorRes);
    }
}