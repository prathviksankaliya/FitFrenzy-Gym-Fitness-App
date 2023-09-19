package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            // Load the initial fragment (e.g., FitnessDetailFragment)
            loadInitialFragment();
        }
    }

    private void loadInitialFragment() {
        // Create an instance of FitnessDetailFragment
        FitnessDetailFragment detailFragment = new FitnessDetailFragment();

        // Pass any data needed to the fragment using arguments (if required)
        Bundle args = new Bundle();
        // args.putParcelable("selectedFitnessItem", selectedFitnessItem); // Pass data if needed
        detailFragment.setArguments(args);

        // Replace the fragment_container with the FitnessDetailFragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .commit();
    }
}
