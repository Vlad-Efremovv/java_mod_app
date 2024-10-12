package com.example.java;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Other extends AppCompatActivity {

    String[] countries = {"Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Spinner spinner = findViewById(R.id.spinner);
        TextView timeTextView = findViewById(R.id.timeTextView);
        TimePicker timePicker = findViewById(R.id.timePicker);

        //exit
        findViewById(R.id.button).setOnClickListener((view) -> finish());

        //radioButton
        findViewById(R.id.radioButton).setOnClickListener((view) -> onRadioButtonClicked(view));
        findViewById(R.id.radioButton2).setOnClickListener((view) -> onRadioButtonClicked(view));

        //checkBox
        findViewById(R.id.checkBox).setOnClickListener(click -> Toast.makeText(this, "checkBox", Toast.LENGTH_LONG).show());

        //timePicker
        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> timeTextView.setText("Время: " + hourOfDay + " : " + minute));

        //spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void onRadioButtonClicked(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checked = radio.isChecked();

        switch (radio.getText().toString()) {
            case "Java":
                if (checked) Toast.makeText(this, "Выбрана Java", Toast.LENGTH_LONG).show();
                break;

            case "Kotlin":
                if (checked) Toast.makeText(this, "Выбрана Kotlin", Toast.LENGTH_LONG).show();
                break;

            default:
                Toast.makeText(this, "Ошибка выбора", Toast.LENGTH_LONG).show();
                break;
        }
    }
}