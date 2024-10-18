package com.example.java;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CustomerData extends AppCompatActivity {

    private Order order;

    private EditText name;
    private EditText adres;
    private EditText phone;
    private TextView time;

    private TextView selectedTimeTextView;

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_data);

        name = findViewById(R.id.editTextText1);
        adres = findViewById(R.id.editTextText2);
        phone = findViewById(R.id.editTextText3);
        time = findViewById(R.id.textView4);

        Bundle arg = getIntent().getExtras();
        if (arg != null) {
            order = (Order) arg.getSerializable(Order.class.getSimpleName());

            if (order.getName() != null) {
                name.setText(order.getName());
                adres.setText(order.getAdres());
                phone.setText(order.getPhone());
                time.setText(order.getTime());
            }
        } else {
            finish();
            Toast.makeText(this, "Ошибка. Вы не выбрали все позиции", Toast.LENGTH_LONG).show();
            return;
        }

        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> time.setText(hourOfDay + " : " + minute));


        findViewById(R.id.button).setOnClickListener((view) -> {

            order.setName(((EditText) findViewById(R.id.editTextText1)).getText().toString());
            order.setAdres(((EditText) findViewById(R.id.editTextText2)).getText().toString());
            order.setPhone(((EditText) findViewById(R.id.editTextText3)).getText().toString());
            order.setTime(time.getText().toString());

            Intent intent = new Intent(CustomerData.this, AllOrder.class);
            intent.putExtra(Order.class.getSimpleName(), order);
            startActivity(intent);
        });

        selectedTimeTextView = findViewById(R.id.selectedTimeTextView);
        Button buttonPickTime = findViewById(R.id.buttonPickTime);

        buttonPickTime.setOnClickListener(v -> showTimePicker());
    }

    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (timePicker, selectedHour, selectedMinute) -> {
                    selectedTimeTextView.setText("Выбранное время: " + selectedHour + ":" + String.format("%02d", selectedMinute));
                }, hour, minute, true); // true для 24-часового формата

        timePickerDialog.show();
    }
}
