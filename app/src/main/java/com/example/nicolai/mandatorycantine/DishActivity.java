package com.example.nicolai.mandatorycantine;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DishActivity extends Activity {
    private TextView title, description, alcohol, carbohydrates, energy, fat, price, protein, weight;
    private Dishes dish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishactivity);

        Intent intent = getIntent();
        dish = (Dishes) intent.getSerializableExtra("DISH");

        title = (TextView) findViewById(R.id.dishlist_item_title);
        title.setText(dish.getTitle());

        description = (TextView) findViewById(R.id.dishlist_item_description);
        description.setText(dish.getDescription());

        alcohol = (TextView) findViewById(R.id.dishlist_item_Alcohol);
        alcohol.setText(String.valueOf(dish.getAlchohol()));

        carbohydrates = (TextView) findViewById(R.id.dishlist_item_Carbohydrates);
        carbohydrates.setText(String.valueOf(dish.getCarbohydrates()));

        energy = (TextView) findViewById(R.id.dishlist_item_Energy);
        energy.setText(String.valueOf(dish.getEnergy()));

        fat = (TextView) findViewById(R.id.dishlist_item_fat);
        fat.setText(String.valueOf(dish.getFat()));

        price = (TextView) findViewById(R.id.dishlist_item_price);
        price.setText(String.valueOf(dish.getPrice()));

        protein = (TextView) findViewById(R.id.dishlist_item_protein);
        protein.setText(String.valueOf(dish.getProtein()));

        weight = (TextView) findViewById(R.id.dishlist_item_weight);
        weight.setText(String.valueOf(dish.getWeight()));


    }
}
