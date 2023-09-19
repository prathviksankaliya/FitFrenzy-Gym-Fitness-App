package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView registrationLink;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        // Initialize views
        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.loginButton);
        registrationLink = view.findViewById(R.id.registrationLink);

        if (getActivity() != null) {
            getActivity().setTitle(""); // Set an empty title
        }

        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login logic here
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if username and password are empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(requireContext(), "Username and password are required.", Toast.LENGTH_SHORT).show();
                } else {
                    // Attempt to log in by comparing with stored registration data
                    if (performLogin(username, password)) {
                        // Login successful, start the HomeActivity
                        startHomeActivity();
                    } else {
                        // Login failed, display an error message
                        Toast.makeText(requireContext(), "Invalid username or password.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set click listener for the registration link
        registrationLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of the RegistrationFragment
                RegisterFragment registrationFragment = new RegisterFragment();

                // Replace the current fragment with the RegistrationFragment
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, registrationFragment)
                        .addToBackStack(null) // Add to the back stack for back navigation
                        .commit();
            }
        });
        return view;
    }

    private boolean performLogin(String username, String password) {
        // Retrieve user registration data from SharedPreferences
        SharedPreferences preferences = requireActivity().getSharedPreferences("UserData", 0);
        String storedUsername = preferences.getString("Username", "");
        String storedPassword = preferences.getString("Password", "");

        // Compare entered username and password with stored data
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    private void startHomeActivity() {
        // Start the HomeActivity upon successful login
        Intent intent = new Intent(requireActivity(), HomeActivity.class);
        startActivity(intent);
        requireActivity().finish(); // Finish the current activity (LoginActivity)
    }
}
