package com.example.java;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Button numButton0;
    Button numButton1;
    Button numButton2;
    Button numButton3;
    Button numButton4;
    Button numButton5;
    Button numButton6;
    Button numButton7;
    Button numButton8;
    Button numButton9;
    Button numButton10;
    Button buttonNew;
    Button buttonHelp;
    Button buttonAnal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memory
        Mem mem = new Mem();

        //title text
        textView = findViewById(R.id.textView);

        //num
        numButton0 = findViewById(R.id.button0);
        numButton1 = findViewById(R.id.button1);
        numButton2 = findViewById(R.id.button2);
        numButton3 = findViewById(R.id.button3);
        numButton4 = findViewById(R.id.button4);
        numButton5 = findViewById(R.id.button5);
        numButton6 = findViewById(R.id.button6);
        numButton7 = findViewById(R.id.button7);
        numButton8 = findViewById(R.id.button8);
        numButton9 = findViewById(R.id.button9);
        numButton10 = findViewById(R.id.button10);

        //dop button
        buttonNew = findViewById(R.id.buttonNew);
        buttonHelp = findViewById(R.id.buttonHelp);
        buttonAnal = findViewById(R.id.buttonAnal);


        OnClickListener onClickListener = view -> {
            //new game
            if (view.getId() == R.id.buttonNew) {

                textView.setText("Новая игра");

                mem.setAllCountLox(mem.getCountLox() + mem.getAllCountLox());

                mem.setCountLox(0);
                mem.newRandom();
            } else if (view.getId() == R.id.buttonHelp) {
                //help rand num
                if (mem.getRandNum() % 2 == 0) {
                    textView.setText("Число четное");
                } else {
                    textView.setText("Число не четное");
                }
            } else if (view.getId() == R.id.buttonAnal) {
                //analytic all game
                textView.setText(
                        "Количество выйграных игр:\t" + mem.getCountNewGame() +
                                "\nКоличество неправильных вводов:\t" + mem.getAllCountLox());
            } else {
                //press button number

                int buttonText = Integer.parseInt(((Button) view).getText().toString());

                if (mem.getRandNum() > buttonText) {

                    textView.setText("Мало");
                    mem.setCountLox(mem.getCountLox() + 1);
                } else if (mem.getRandNum() < buttonText) {

                    textView.setText("Много");
                    mem.setCountLox(mem.getCountLox() + 1);
                } else {

                    textView.setText("Точно в цель\nКоличество попыток: " + mem.getCountLox());
                    mem.setCountNewGame(mem.getCountNewGame() + 1);
                }
            }

        };

        //num
        numButton0.setOnClickListener(onClickListener);
        numButton1.setOnClickListener(onClickListener);
        numButton2.setOnClickListener(onClickListener);
        numButton3.setOnClickListener(onClickListener);
        numButton4.setOnClickListener(onClickListener);
        numButton5.setOnClickListener(onClickListener);
        numButton6.setOnClickListener(onClickListener);
        numButton7.setOnClickListener(onClickListener);
        numButton8.setOnClickListener(onClickListener);
        numButton9.setOnClickListener(onClickListener);
        numButton10.setOnClickListener(onClickListener);

        //dop button
        buttonNew.setOnClickListener(onClickListener);
        buttonHelp.setOnClickListener(onClickListener);
        buttonAnal.setOnClickListener(onClickListener);
    }
}