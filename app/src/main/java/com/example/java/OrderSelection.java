package com.example.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSelection extends AppCompatActivity {

    Order order;

    String[] countries = {"Паста", "Стейк", "Рыба"};
    String course;
    boolean[] dipChecked = new boolean[3];

    boolean next = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_selection);

        Bundle arg = getIntent().getExtras();
        if (arg != null && arg.getSerializable(Order.class.getSimpleName()) != null) {
            order = (Order) arg.getSerializable(Order.class.getSimpleName());
            next = false;
        }

        //spinner
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //radioButton
        findViewById(R.id.radioButton1).setOnClickListener(this::onRadioButtonClicked);
        findViewById(R.id.radioButton2).setOnClickListener(this::onRadioButtonClicked);
        findViewById(R.id.radioButton3).setOnClickListener(this::onRadioButtonClicked);

        // CheckBox
        checkBoxListener();

        //next screen
        findViewById(R.id.button).setOnClickListener(click -> {
            if (next) {
                order = new Order(spinner.getSelectedItem().toString(), course, getCheckedDips());
            } else {
                order.setMainСourse(spinner.getSelectedItem().toString());
                order.setCourse(course);
                order.setDip(getCheckedDips());
            }

            Intent intent;
            intent = new Intent(OrderSelection.this, CustomerData.class);

            intent.putExtra(Order.class.getSimpleName(), order);
            startActivity(intent);

        });
    }

    private void checkBoxListener() {
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);

        checkBox1.setOnClickListener(view -> dipChecked[0] = checkBox1.isChecked());
        checkBox2.setOnClickListener(view -> dipChecked[1] = checkBox2.isChecked());
        checkBox3.setOnClickListener(view -> dipChecked[2] = checkBox3.isChecked());
    }

    private String[] getCheckedDips() {
        // Сбор выбранных соусов (CheckBox)
        String[] dips = new String[3];

        dips[0] = dipChecked[0] ? "Сырный" : null;
        dips[1] = dipChecked[0] ? "Брусничный" : null;
        dips[2] = dipChecked[0] ? "Соевый" : null;

        return dips;
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checked = radio.isChecked();

        switch (radio.getText().toString()) {
            case "Картошка":
                if (checked) course = "Картошка";
                break;

            case "Деревня":
                if (checked) course = "Деревня";
                break;

            case "Медальки":
                if (checked) course = "Медальки";
                break;

            default:
                Toast.makeText(this, "Ошибка выбора", Toast.LENGTH_LONG).show();
                break;
        }
    }
}