package com.example.fitnesstrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculCaloriiActivity extends AppCompatActivity {

    String varsta, inaltime, greutate;
    EditText editTextVarsta;
    EditText editTextInaltime;
    EditText editTextGreutate;

    RadioGroup radioGroup;

    RadioButton rbBarbat;
    RadioButton rbFemeie;
    RadioButton rbSedentar;
    RadioButton rbModerat;
    RadioButton rbActiv;

    RadioButton rbSlabesc;
    RadioButton rbIngras;
    RadioButton rbMentin;

    Button calculCaloriesBtn;

    TextView txtViewCalories;

//////////////////////////////////////////////////////
    double BMI = 0;
    double caloriesMenSedentarMentinere = 0;
    double caloriesWomenSedentarMentinere = 0;

    double caloriesMenSedentarDeficit = 0;
    double caloriesWomenSedentarDeficit = 0;

    double caloriesMenSedentarSurplus = 0;
    double caloriesWomenSedentarSurplus = 0;

    double caloriesMenModeratMentinere = 0;
    double caloriesWomenModeratMentinere = 0;

    double caloriesMenModeratDeficit = 0;
    double caloriesWomenModeratDeficit = 0;

    double caloriesMenModeratSurplus = 0;
    double caloriesWomenModeratSurplus = 0;

    double caloriesMenActivMentinere = 0;
    double caloriesWomenActivMentinere = 0;

    double caloriesMenActivDeficit = 0;
    double caloriesWomenActivDeficit = 0;

    double caloriesMenActivSurplus = 0;
    double caloriesWomenActivSurplus = 0;

    double BMICalories = 0;
////////////////////////////////////////////////////


    public static String caloriesMenSedentarMentinereResult;
    public static String caloriesMenModeratMentinereResult;
    public static String caloriesMenActivMentinereResult;

    public static String caloriesMenSedentarDeficitResult;
    public static String caloriesMenModeratDeficitResult;
    public static String caloriesMenActivDeficitResult;

    public static String caloriesMenSedentarSurplusResult;
    public static String caloriesMenModeratSurplusResult;
    public static String caloriesMenActivSurplusResult;

///////////////////////////////////////////////////////////////////

    public static String caloriesWomenSedentarMentinereResult;
    public static String caloriesWomenModeratMentinereResult;
    public static String caloriesWomenActivMentinereResult;

    public static String caloriesWomenSedentarDeficitResult;
    public static String caloriesWomenModeratDeficitResult;
    public static String caloriesWomenActivDeficitResult;

    public static String caloriesWomenSedentarSurplusResult;
    public static String caloriesWomenModeratSurplusResult;
    public static String caloriesWomenActivSurplusResult;

    ///////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_calculcalorii);

        txtViewCalories = (TextView) findViewById(R.id.txtViewCalories);

        editTextVarsta = (EditText) findViewById(R.id.editTextVarsta);
        editTextInaltime = (EditText) findViewById(R.id.editTextInaltime);
        editTextGreutate = (EditText) findViewById(R.id.editTextGreutate);

        rbBarbat = (RadioButton) findViewById(R.id.rbBarbat);
        rbFemeie = (RadioButton) findViewById(R.id.rbFemeie);

        rbSedentar = (RadioButton) findViewById(R.id.rbSedentar);
        rbModerat = (RadioButton) findViewById(R.id.rbModerat);
        rbActiv = (RadioButton) findViewById(R.id.rbActiv);

        rbSlabesc = (RadioButton) findViewById(R.id.rbSlabesc);
        rbMentin = (RadioButton) findViewById(R.id.rbMentin);
        rbIngras = (RadioButton) findViewById(R.id.rbIngras);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        calculCaloriesBtn = (Button) findViewById(R.id.calculCaloriesBtn);


        calculCaloriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                varsta = editTextVarsta.getText().toString();
                inaltime = editTextInaltime.getText().toString();
                greutate = editTextGreutate.getText().toString();

                double doubleVarsta = Double.parseDouble(varsta);
                double doubleInaltime = Double.parseDouble(inaltime);
                double doubleGreutate = Double.parseDouble(greutate);

                BMI = ((doubleGreutate / doubleInaltime) / doubleInaltime) * 10000;
                String sBMI = String.valueOf(BMI);
                BMICalories = 10 * doubleGreutate + 6.25 * doubleInaltime - 5 * doubleVarsta;

                menVariablesAndConditions();
                womenVariablesAndConditions();

            }
        });
    }

    public void menVariablesAndConditions(){

        //men variables
        caloriesMenSedentarMentinere = BMICalories + 366;
        caloriesMenModeratMentinere = BMICalories + 844;
        caloriesMenActivMentinere = BMICalories + 998;

        caloriesMenSedentarDeficit = BMICalories + 139;
        caloriesMenModeratDeficit = BMICalories + 339;
        caloriesMenActivDeficit = BMICalories + 493;

        caloriesMenSedentarSurplus = BMICalories + 861;
        caloriesMenModeratSurplus = BMICalories + 1339;
        caloriesMenActivSurplus = BMICalories + 1493;

        caloriesMenSedentarMentinereResult = (String.valueOf(caloriesMenSedentarMentinere) + " calories");
        caloriesMenModeratMentinereResult = (String.valueOf(caloriesMenModeratMentinere) + " calories");
        caloriesMenActivMentinereResult = (String.valueOf(caloriesMenActivMentinere) + " calories");

        caloriesMenSedentarDeficitResult = String.valueOf(caloriesMenSedentarDeficit);
        caloriesMenModeratDeficitResult = (String.valueOf(caloriesMenModeratDeficit)  + " calories");
        caloriesMenActivDeficitResult = (String.valueOf(caloriesMenActivDeficit)  + " calories");

        caloriesMenSedentarSurplusResult = (String.valueOf(caloriesMenSedentarSurplus)  + " calories");
        caloriesMenModeratSurplusResult = (String.valueOf(caloriesMenModeratSurplus) + " calories");
        caloriesMenActivSurplusResult = (String.valueOf(caloriesMenActivSurplus) + " calories");

        //BARBAT SEDENTAR
        if (rbBarbat.isChecked() && rbSedentar.isChecked() && rbSlabesc.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenSedentarDeficitResult);
            startActivity(intent);
        }

        else if (rbBarbat.isChecked() && rbSedentar.isChecked() && rbMentin.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenSedentarMentinereResult);
            startActivity(intent);
        }

        else if (rbBarbat.isChecked() && rbSedentar.isChecked() && rbIngras.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenSedentarSurplusResult);
            startActivity(intent);
        }

        //BARBAT MODERAT
        else if (rbBarbat.isChecked() && rbModerat.isChecked() && rbSlabesc.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenModeratDeficitResult);
            startActivity(intent);
        }

        else if (rbBarbat.isChecked() && rbModerat.isChecked() && rbMentin.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenModeratMentinereResult);
            startActivity(intent);
        }

        else if (rbBarbat.isChecked() && rbModerat.isChecked() && rbIngras.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenModeratSurplusResult);
            startActivity(intent);
        }

        //BARBAT ACTIV
        else if (rbBarbat.isChecked() && rbActiv.isChecked() && rbSlabesc.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenActivDeficitResult);
            startActivity(intent);
        }

        else if (rbBarbat.isChecked() && rbActiv.isChecked() && rbMentin.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenActivMentinereResult);
            startActivity(intent);
        }

        else if (rbBarbat.isChecked() && rbActiv.isChecked() && rbIngras.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesMenActivSurplusResult);
            startActivity(intent);

        }
    }

    public void womenVariablesAndConditions(){

        //women variables
        caloriesWomenSedentarMentinere = BMICalories +328;
        caloriesWomenModeratMentinere = BMICalories +762;
        caloriesWomenActivMentinere = BMICalories +901;

        caloriesWomenSedentarDeficit = BMICalories +156;
        caloriesWomenModeratDeficit = BMICalories +400;
        caloriesWomenActivDeficit = BMICalories +500;

        caloriesWomenSedentarSurplus = BMICalories + 500;
        caloriesWomenModeratSurplus = BMICalories + 1000;
        caloriesWomenActivSurplus = BMICalories + 1100;


        caloriesWomenSedentarMentinereResult = String.valueOf(caloriesWomenSedentarMentinere);
        caloriesWomenModeratMentinereResult = String.valueOf(caloriesWomenModeratMentinere);
        caloriesWomenActivMentinereResult = String.valueOf(caloriesWomenActivMentinere);

        caloriesWomenSedentarDeficitResult = String.valueOf(caloriesWomenSedentarDeficit);
        caloriesWomenModeratDeficitResult = String.valueOf(caloriesWomenModeratDeficit);
        caloriesWomenActivDeficitResult = String.valueOf(caloriesWomenActivDeficit);

        caloriesWomenSedentarSurplusResult = String.valueOf(caloriesWomenSedentarSurplus);
        caloriesWomenModeratSurplusResult = String.valueOf(caloriesWomenModeratSurplus);
        caloriesWomenActivSurplusResult = String.valueOf(caloriesWomenActivSurplus);

        //FEMEIE SEDENTAR
        if (rbFemeie.isChecked() && rbSedentar.isChecked() && rbSlabesc.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesWomenSedentarDeficitResult);
            startActivity(intent);

            Intent intent1 = new Intent(calculCaloriiActivity.this, adaugaMancareActivity.class);
        }

        else if (rbFemeie.isChecked() && rbSedentar.isChecked() && rbMentin.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesWomenSedentarMentinereResult);
            startActivity(intent);
        }

        else if (rbFemeie.isChecked() && rbSedentar.isChecked() && rbIngras.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesWomenSedentarSurplusResult);
            startActivity(intent);
        }

        //FEMEIE MODERAT
        else if (rbFemeie.isChecked() && rbModerat.isChecked() && rbSlabesc.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesWomenModeratDeficitResult);
            startActivity(intent);
        }

        else if (rbFemeie.isChecked() && rbModerat.isChecked() && rbMentin.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesWomenModeratMentinereResult);
            startActivity(intent);
        }

        else if (rbFemeie.isChecked() && rbModerat.isChecked() && rbIngras.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories", caloriesWomenModeratSurplusResult);
            startActivity(intent);
        }

        //FEMEIE ACTIV
        else if (rbFemeie.isChecked() && rbActiv.isChecked() && rbSlabesc.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories",  caloriesWomenActivDeficitResult);
            startActivity(intent);
        }

        else if (rbFemeie.isChecked() && rbActiv.isChecked() && rbMentin.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories",  caloriesWomenActivMentinereResult);
            startActivity(intent);
        }

        else if (rbFemeie.isChecked() && rbActiv.isChecked() && rbIngras.isChecked()) {
            Intent intent = new Intent(calculCaloriiActivity.this, mainActivity.class);
            intent.putExtra("calories",   caloriesWomenActivSurplusResult);
            startActivity(intent);
        }
    }
}
