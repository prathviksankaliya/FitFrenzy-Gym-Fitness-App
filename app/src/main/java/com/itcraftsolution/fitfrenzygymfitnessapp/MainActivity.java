package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String USER_REGISTERED_KEY = "user_registered";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the SplashFragment initially
        loadFragment(new SplashFragment());

        // Check user's login status and load the appropriate fragment
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean userRegistered = settings.getBoolean(USER_REGISTERED_KEY, false);

        if (!userRegistered) {
            // If the user is not registered, show the RegisterFragment
            loadFragment(new RegisterFragment());
        } else {
            // If the user is registered, show the LoginFragment
            loadFragment(new LoginFragment());
        }
    }

    // Method to load a fragment into the container
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}

