package com.example.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonImp;
    Button buttonClass;
    Button buttonOther;
    EditText editTextName;
    EditText editTextAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonImp = findViewById(R.id.button);
        buttonClass = findViewById(R.id.button2);
        buttonOther = findViewById(R.id.button3);
        editTextName = findViewById(R.id.editTextText);
        editTextAge = findViewById(R.id.editTextNumber);

        buttonImp.setOnClickListener(this);
        buttonClass.setOnClickListener(this);
        buttonOther.setOnClickListener(e -> startActivity(new Intent(MainActivity.this, Other.class)));
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Second.class);

        String name = editTextName.getText().toString();
        int age;

        if (name.isEmpty()) {
            editTextName.setError("Введите имя");
            return;
        }

        try {
            age = Integer.parseInt(editTextAge.getText().toString());
        } catch (Exception e) {
            editTextAge.setError("Введите число");
            return;
        }

        if (view.getId() == R.id.button) {
            intent.putExtra("name", name);
            intent.putExtra("age", age);
        } else {
            Men men = new Men(name, age);
            intent.putExtra(Men.class.getSimpleName(), men);
        }

        startActivity(intent);
    }

}
