package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewsActivity extends AppCompatActivity {
    private Button mButtonDetails;
    private Button mButtonLogout;
    private Button mButtonAbout;
    private TextView afficheLogin;
    private String login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());
        mButtonDetails=findViewById(R.id.button_details);
        mButtonLogout=findViewById(R.id.button_logout);
        mButtonAbout=findViewById(R.id.button_about);
        afficheLogin=findViewById(R.id.affiche_login);

        Intent intent = getIntent();
        if(intent.hasExtra("login")){
            setLogin(intent.getStringExtra("login"));
            afficheLogin.setText(getLogin());
        }

        mButtonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(NewsActivity.this, DetailsActivity.class);
                startActivity(gameActivityIntent);
            }
        });
        mButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(NewsActivity.this, LoginActivity.class);
                startActivity(gameActivityIntent);
            }
        });
        mButtonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
    public void setLogin(String login){
        this.login=login;
    }
    public String getLogin(){
        return this.login;
    }

}