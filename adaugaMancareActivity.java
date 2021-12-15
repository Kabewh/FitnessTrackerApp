package com.example.fitnesstrackerapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class adaugaMancareActivity extends AppCompatActivity {

    TextView caloriesTotal;
    TextView caloriesConsumed;
    TextView caloriesLeft;
    ListView listView;
    String[] name = {"pizza", "mar", "banana", "lapte"};

    ArrayAdapter<String> arrayAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_adaugamancare);

        caloriesTotal = (TextView) findViewById(R.id.caloriesTotal);
        listView = (ListView) findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        String caloriesMenSedentarDeficitResult = intent.getStringExtra("calorii");

        caloriesTotal.setText(caloriesMenSedentarDeficitResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setContentView(R.layout.activity_adaugamancare);
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}

