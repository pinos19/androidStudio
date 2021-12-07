package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button mLoginButton;
    private EditText mUserName;
    private String userString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());
        mLoginButton=findViewById(R.id.button_login);
        mUserName=findViewById(R.id.username);
        setUserName("");

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = getUserName();
                if(username != ""){
                    NewsListApplication app = (NewsListApplication) getApplicationContext();
                    app.setLogin(username);
                    Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                    intent.putExtra("login",username);
                    startActivity(intent);
                    finish();
                }
            }
        });
        mUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                setUserName(s.toString());
            }
        });
    }
    public void setUserName(String username){
        this.userString=username;
    }
    public String getUserName(){
        return this.userString;
    }
}