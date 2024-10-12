package com.example.java;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {

    TextView textViewName;
    TextView textViewAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);

        findViewById(R.id.button).setOnClickListener((view) -> finish());

        Bundle arg = getIntent().getExtras();
        if (arg != null && arg.getSerializable(Men.class.getSimpleName()) != null) {

            Men men = (Men) arg.getSerializable(Men.class.getSimpleName());

            textViewName.setText(men.getName().toString());
            textViewAge.setText(men.getAge().toString());
        } else if (arg != null) {

            textViewName.setText(arg.getString("name", "Ошибка чтения"));
            textViewAge.setText(String.valueOf(arg.getInt("age", 0)));
        } else {

            textViewName.setText("Имя не указано");
            textViewAge.setText(0);
        }
    }
}
