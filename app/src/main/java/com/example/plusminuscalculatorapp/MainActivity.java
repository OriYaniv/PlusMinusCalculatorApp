package com.example.plusminuscalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewNumber;
    private Button buttonPlus, buttonMinus;
    private EditText editTextNumber1, editTextNumber2;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initListeners();
    }

    private void initUI() {
        textViewNumber = findViewById(R.id.textViewNumber);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
    }

    private void initListeners() {
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
    }

    private void performButtonTask(int task) {
        if (editTextNumber1.getText().toString().matches("") ||
                editTextNumber2.getText().toString().matches("")) {
            textViewNumber.setText("");
        } else {
            result = task;
            textViewNumber.setText(String.valueOf(result));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonPlus) {
            performButtonTask(Integer.parseInt(editTextNumber1.getText().toString())
                    + Integer.parseInt(editTextNumber2.getText().toString()));
        }
        if (v.getId() == R.id.buttonMinus) {
            performButtonTask(Integer.parseInt(editTextNumber1.getText().toString())
                    - Integer.parseInt(editTextNumber2.getText().toString()));
        }
    }

}
