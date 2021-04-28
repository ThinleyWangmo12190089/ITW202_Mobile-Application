package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText messageOne;
    private EditText messageTwo;
    private TextView answer;

    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageOne = findViewById(R.id.editTextOne);
        messageTwo = findViewById(R.id.editTextTwo);
        answer = findViewById(R.id.textView_answer);

        mCalculator = new Calculator();
    }

    public void Add(View view) {
        String operandOne = messageOne.getText().toString();
        String operandTwo = messageTwo.getText().toString();

        double value = mCalculator.add(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        answer.setText(String.valueOf(value));

    }

    public void Sub(View view) {
        String operandOne = messageOne.getText().toString();
        String operandTwo = messageTwo.getText().toString();

        double value = mCalculator.sub(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        answer.setText(String.valueOf(value));
    }

    public void Mul(View view) {
        String operandOne = messageOne.getText().toString();
        String operandTwo = messageTwo.getText().toString();

        double value = mCalculator.mul(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        answer.setText(String.valueOf(value));
    }

    public void Div(View view) {
        String operandOne = messageOne.getText().toString();
        String operandTwo = messageTwo.getText().toString();

        double value = mCalculator.div(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        answer.setText(String.valueOf(value));
    }
}