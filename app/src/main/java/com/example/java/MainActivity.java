package com.example.java;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(e -> startActivity(new Intent(MainActivity.this, Other.class)));
        findViewById(R.id.button2).setOnClickListener(e -> startActivity(new Intent(MainActivity.this, Other.class)));
        findViewById(R.id.button3).setOnClickListener(e -> startActivity(new Intent(MainActivity.this, Other.class)));
        findViewById(R.id.button4).setOnClickListener(e -> startActivity(new Intent(MainActivity.this, Other.class)));
        findViewById(R.id.button5).setOnClickListener(e -> startActivity(new Intent(MainActivity.this, Other.class)));

    }
}
