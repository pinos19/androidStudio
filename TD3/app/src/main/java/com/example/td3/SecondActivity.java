package com.example.td3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button mGameButton;
    private Button mPassNextButton;
    private Button mPassPreButton;
    private TextView mTextViewDice1;
    private TextView mTextViewDice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mGameButton = findViewById(R.id.button_deux_des);
        mPassNextButton =findViewById(R.id.button_next_act3);
        mPassPreButton =findViewById(R.id.button_pre_act1);
        mTextViewDice1 =findViewById(R.id.textview_de1);
        mTextViewDice2 =findViewById(R.id.textview_de2);

        mGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long random_number1,random_number2;
                random_number1 = Math.round(Math.random() * 5)+1;
                random_number2 = Math.round(Math.random() * 5)+1;
                mTextViewDice1.setText(String.valueOf(random_number1));
                mTextViewDice2.setText(String.valueOf(random_number2));
            }
        });
        mPassNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(gameActivityIntent);
            }
        });
        mPassPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}
