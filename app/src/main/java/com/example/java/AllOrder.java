package com.example.java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AllOrder extends AppCompatActivity {

    private Order order;

    private TextView textViewMainCourse;
    private TextView textViewAdres;
    private TextView textViewPhone;
    private TextView textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order);

        Bundle arg = getIntent().getExtras();
        if (arg != null && arg.getSerializable(Order.class.getSimpleName()) != null) {
            order = (Order) arg.getSerializable(Order.class.getSimpleName());
        } else {
            finish();
            Toast.makeText(this, "Ошибка. Вы не заполнили всю информацию", Toast.LENGTH_LONG).show();
            return;
        }
        fillingTextView();

        findViewById(R.id.button).setOnClickListener(click -> {
            Intent intent = new Intent(AllOrder.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Toast.makeText(this, "Ваш заказ готовится и будет доставлен\nк " + textViewTime.getText(), Toast.LENGTH_LONG).show();
        });

        findViewById(R.id.buttonEdit).setOnClickListener(click -> {
            Intent intent = new Intent(AllOrder.this, OrderSelection.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra(Order.class.getSimpleName(), order);
            startActivity(intent);
        });
    }

    private void fillingTextView() {
        textViewMainCourse = findViewById(R.id.textView11);
        textViewAdres = findViewById(R.id.textView21);
        textViewPhone = findViewById(R.id.textView31);
        textViewTime = findViewById(R.id.textView41);

        textViewMainCourse.setText(order.getMainСourse());
        textViewAdres.setText(order.getAdres());
        textViewPhone.setText(order.getPhone());
        textViewTime.setText(order.getTime());
    }
}