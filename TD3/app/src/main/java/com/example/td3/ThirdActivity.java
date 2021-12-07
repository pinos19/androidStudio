package com.example.td3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private Button mGameButton;
    private Button mPassPreButton;
    private TextView mTextViewDice1;
    private TextView mTextViewDice2;
    private EditText mEditTextDice1;
    private EditText mEditTextDice2;
    private int nbFacesDe1;
    private int nbFacesDe2;
    public void setNbFacesDe1(int nbFacesDe1){
        this.nbFacesDe1 = nbFacesDe1;
    }
    public void setNbFacesDe2(int nbFacesDe2){
        this.nbFacesDe2=nbFacesDe2;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mGameButton = findViewById(R.id.button_act3);
        mPassPreButton =findViewById(R.id.button_pre_act2);
        mTextViewDice1 =findViewById(R.id.textview_de1_act3);
        mTextViewDice2 =findViewById(R.id.textview_de2_act3);
        mEditTextDice1 =findViewById(R.id.face_de1);
        mEditTextDice2 =findViewById(R.id.face_de2);
        setNbFacesDe1(6);
        setNbFacesDe2(6);
        mEditTextDice1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                boolean entry_is_numeric;
                entry_is_numeric = s.chars().allMatch( Character::isDigit );
                if(!s.toString().isEmpty()){
                    if (entry_is_numeric && Integer.valueOf(String.valueOf(s))>1){
                        setNbFacesDe1(Integer.valueOf(String.valueOf(s)));
                    }else{
                        Toast.makeText(ThirdActivity.this,"Erreur, veuillez entrer un nombre supérieur à 1",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mEditTextDice2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                boolean entry_is_numeric;
                entry_is_numeric = s.chars().allMatch( Character::isDigit );
                if(!s.toString().isEmpty()){
                    if (entry_is_numeric && Integer.valueOf(String.valueOf(s))>1){
                        setNbFacesDe2(Integer.valueOf(String.valueOf(s)));
                    }else{
                        Toast.makeText(ThirdActivity.this,"Erreur, veuillez entrer un nombre supérieur à 1",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long random_number1,random_number2;
                random_number1 = Math.round(Math.random() * (nbFacesDe1-1))+1;
                random_number2 = Math.round(Math.random() * (nbFacesDe2-1))+1;
                mTextViewDice1.setText(String.valueOf(random_number1));
                mTextViewDice2.setText(String.valueOf(random_number2));
            }
        });
        mPassPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }

}
