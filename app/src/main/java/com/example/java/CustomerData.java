package com.example.java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_data);

        TimePicker timePicker = findViewById(R.id.timePicker);
        TextView timeTextView = findViewById(R.id.textView4);


        findViewById(R.id.button).setOnClickListener((view) ->
                startActivity(new Intent(CustomerData.this, AllOrder.class)));

        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) ->
                timeTextView.setText("Время: " + hourOfDay + " : " + minute));


//        Bundle arg = getIntent().getExtras();
//        if (arg != null && arg.getSerializable(Order.class.getSimpleName()) != null) {
//
//            Order order = (Order) arg.getSerializable(Order.class.getSimpleName());
//
//            textViewName.setText(order.getName().toString());
//            textViewAge.setText(order.getAge().toString());
//        } else if (arg != null) {
//
//            textViewName.setText(arg.getString("name", "Ошибка чтения"));
//            textViewAge.setText(String.valueOf(arg.getInt("age", 0)));
//        } else {
//
//            textViewName.setText("Имя не указано");
//            textViewAge.setText(0);
//        }
    }
}
