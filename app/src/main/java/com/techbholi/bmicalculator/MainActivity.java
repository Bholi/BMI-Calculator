package com.techbholi.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView Bmi_calc,weight,height,your_bmi,value,result;
    EditText weight_value,height_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        Bmi_calc = findViewById(R.id.BMICalc);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        your_bmi = findViewById(R.id.your_bmi);
        value = findViewById(R.id.bmi_value);
        result = findViewById(R.id.BMI);
        weight_value = findViewById(R.id.weight_value);
        height_value = findViewById(R.id.height_value);

        button.setOnClickListener(v -> {
            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);

            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            calculate_BMI();
        });
    }
    @SuppressLint("SetTextI18n")
    public void calculate_BMI(){
     String h = height_value.getText().toString().trim();
     float hi = Float.parseFloat(h);
     String w = weight_value.getText().toString().trim();
     float we = Float.parseFloat(w);
     float ans = we/(hi*hi);
     value.setText(ans+"");
     if(ans <= 18.5)
     {
         value.setTextColor(Color.RED);
         result.setTextColor(Color.BLUE);
     }
     else if(ans>25)
     {
         value.setTextColor(Color.YELLOW);
         result.setTextColor(Color.YELLOW);
     }
     else{
         value.setTextColor(Color.GREEN);
     }
     {

     }
     if (ans<=15)
     {
         result.setText("You are very severely underweight");
     }
     else if(ans >15 && ans <=16 )
     {
         result.setText("You are severely underweight");
     }
     else if(ans > 16 && ans <=18.5)
     {
         result.setText("You are underweight");
     }
     else if(ans> 18.5 && ans<=25)
     {
         result.setText("You are Normal");
         result.setTextColor(Color.GREEN);
     }
     else if(ans>25 && ans<=30)
     {
         result.setText("You are Overweight");
     }
     else if(ans>30 && ans <= 35)
     {
         result.setText("You are Moderately Obese");
     }
     else if(ans>35 && ans<=40)
     {
         result.setText("You are severely Obese");
     }
     else
     {
         result.setText("You are Very Severely Obese");
     }
    }
}