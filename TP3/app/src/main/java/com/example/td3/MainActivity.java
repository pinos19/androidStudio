package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mGameButton;
    private Button mPassNextButton;
    private TextView mTextViewDice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGameButton = findViewById(R.id.button_de);
        mPassNextButton =findViewById(R.id.button_next_act2);
        mTextViewDice =findViewById(R.id.textview_de);
        mGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long random_number;
                random_number = Math.round(Math.random() * 5)+1;
                mTextViewDice.setText(String.valueOf(random_number));
            }
        });
        mPassNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}