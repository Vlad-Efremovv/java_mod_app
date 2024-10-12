package com.example.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSelection extends AppCompatActivity {

    String[] countries = {"Паста", "Стейк", "Рыба"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_selection);

        Spinner spinner = findViewById(R.id.spinner);

        //spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //radioButton
        findViewById(R.id.radioButton1).setOnClickListener((view) -> onRadioButtonClicked(view));
        findViewById(R.id.radioButton2).setOnClickListener((view) -> onRadioButtonClicked(view));
        findViewById(R.id.radioButton2).setOnClickListener((view) -> onRadioButtonClicked(view));

        //checkBox
        findViewById(R.id.checkBox1).setOnClickListener(click -> {});
        findViewById(R.id.checkBox1).setOnClickListener(click -> {});
        findViewById(R.id.checkBox1).setOnClickListener(click -> {});

        //next screen
        findViewById(R.id.button).setOnClickListener(click ->
                startActivity(new Intent(OrderSelection.this, CustomerData.class)));
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checked = radio.isChecked();

        switch (radio.getText().toString()) {
            case "Картошка":
                if (checked) {}
                break;

            case "Деревня":
                if (checked) {}
                break;

            case "Медальки":
                if (checked) {}
                break;

            default:
                Toast.makeText(this, "Ошибка выбора", Toast.LENGTH_LONG).show();
                break;
        }
    }
}