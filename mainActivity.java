package com.example.fitnesstrackerapp;

import static com.example.fitnesstrackerapp.calculCaloriiActivity.caloriesMenSedentarDeficitResult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class mainActivity extends AppCompatActivity {

    Button calculCaloriiBtn;
    Button mainButton;
    Button addFoodButton;
    TextView txtViewCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        calculCaloriiBtn = (Button) findViewById(R.id.calculCaloriiBtn);
        mainButton = (Button) findViewById(R.id.mainButton);
        txtViewCalories = (TextView) findViewById(R.id.txtViewCalories);
        addFoodButton = (Button) findViewById(R.id.addFoodButton);

        calculCaloriiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity.this, calculCaloriiActivity.class);
                startActivity(intent);
            }
        });

        addFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity.this, adaugaMancareActivity.class);
                intent.putExtra("calorii", caloriesMenSedentarDeficitResult);
                startActivity(intent);
            }
        });

        setCaloriesToMain();
    }

    public void setCaloriesToMain(){
        Intent intent = getIntent();

        ///// men
        String caloriesMenSedentarDeficitResult = intent.getStringExtra("calories");
        String caloriesMenSedentarMentinereResult = intent.getStringExtra("calories");
        String caloriesMenSedentarSurplusResult = intent.getStringExtra("calories");

        String caloriesMenModeratDeficitResult = intent.getStringExtra("calories");
        String caloriesMenModeratMentinereResult = intent.getStringExtra("calories");
        String caloriesMenModeratSurplusResult = intent.getStringExtra("calories");

        String caloriesMenActivDeficitResult = intent.getStringExtra("calories");
        String caloriesMenActivMentinereResult = intent.getStringExtra("calories");
        String caloriesMenActivSurplusResult = intent.getStringExtra("calories");


        txtViewCalories.setText(caloriesMenSedentarDeficitResult);
        txtViewCalories.setText(caloriesMenSedentarMentinereResult);
        txtViewCalories.setText(caloriesMenSedentarSurplusResult);

        txtViewCalories.setText(caloriesMenModeratDeficitResult);
        txtViewCalories.setText(caloriesMenModeratMentinereResult);
        txtViewCalories.setText(caloriesMenModeratSurplusResult);

        txtViewCalories.setText(caloriesMenActivDeficitResult);
        txtViewCalories.setText(caloriesMenActivMentinereResult);
        txtViewCalories.setText(caloriesMenActivSurplusResult);



        ///// woman

        String caloriesWomenSedentarDeficitResult = intent.getStringExtra("calories");
        String caloriesWomenSedentarMentinereResult = intent.getStringExtra("calories");
        String caloriesWomenSedentarSurplusResult = intent.getStringExtra("calories");

        String caloriesWomenModeratDeficitResult = intent.getStringExtra("calories");
        String caloriesWomenModeratMentinereResult = intent.getStringExtra("calories");
        String caloriesWomenModeratSurplusResult = intent.getStringExtra("calories");

        String caloriesWomenActivDeficitResult = intent.getStringExtra("calories");
        String caloriesWomenActivMentinereResult = intent.getStringExtra("calories");
        String caloriesWomenActivSurplusResult = intent.getStringExtra("calories");


        txtViewCalories.setText(caloriesWomenSedentarDeficitResult);
        txtViewCalories.setText(caloriesWomenSedentarMentinereResult);
        txtViewCalories.setText(caloriesWomenSedentarSurplusResult);

        txtViewCalories.setText(caloriesWomenModeratDeficitResult);
        txtViewCalories.setText(caloriesWomenModeratMentinereResult);
        txtViewCalories.setText(caloriesWomenModeratSurplusResult);

        txtViewCalories.setText(caloriesWomenActivDeficitResult);
        txtViewCalories.setText(caloriesWomenActivMentinereResult);
        txtViewCalories.setText(caloriesWomenActivSurplusResult);
    }
}