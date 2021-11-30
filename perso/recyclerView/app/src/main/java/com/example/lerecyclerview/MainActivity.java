package com.example.lerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] s1, s2;
    int[] images={R.drawable.c_plus_plus,
                R.drawable.c_sharp,
                R.drawable.java,
                R.drawable.kotlin,
                R.drawable.swift,
                R.drawable.ruby,
                R.drawable.typescript,
                R.drawable.python,
                R.drawable.visualstudio,
                R.drawable.javascript};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        
        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}