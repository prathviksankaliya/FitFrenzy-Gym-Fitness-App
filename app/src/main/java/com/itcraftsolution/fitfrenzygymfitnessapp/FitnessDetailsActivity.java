package com.itcraftsolution.fitfrenzygymfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FitnessDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_details);

        // Initialize views
        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailTitleTextView = findViewById(R.id.detailTitleTextView);
        TextView detailCaloriesTextView = findViewById(R.id.detailCaloriesTextView);
        Button doneButton = findViewById(R.id.doneButton);

        // Retrieve fitness item data from SharedPreferences
        FitnessItem clickedItem = FitnessItem.loadFromSharedPreferences(this);

        // Set data to views
        detailImageView.setImageResource(clickedItem.getImageResId());
        detailTitleTextView.setText(clickedItem.getTitle());
        detailCaloriesTextView.setText("Calories Gain: " + clickedItem.getCalories());

        // Handle the "Done" button click
        doneButton.setOnClickListener(view -> {
            // Implement your logic when the "Done" button is clicked
            // For example, you can go back to the HomeActivity
            Intent intent = new Intent(FitnessDetailsActivity.this, FinishActivity.class);
            startActivity(intent);

            // Finish the current activity (FitnessDetailsActivity)
            finish();
        });
    }
}
