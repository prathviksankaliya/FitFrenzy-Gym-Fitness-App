package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterFragment extends Fragment {

    private EditText nameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Find the EditText fields by their IDs
        nameEditText = view.findViewById(R.id.nameEditText);
        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);

        // Find the Register button by its ID
        Button registerButton = view.findViewById(R.id.registerButton);

        // Set an OnClickListener for the Register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the registration process here
                registerUser();
            }
        });

        TextView loginLink = view.findViewById(R.id.loginLink);

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLoginFragment();
            }
        });

        return view;
    }

    private void registerUser() {
        // Get the user input from the EditText fields
        String name = nameEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Check if any of the fields are empty
        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
        } else {
            // Store the user registration data in SharedPreferences
            SharedPreferences preferences = requireActivity().getSharedPreferences("UserData", 0);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Name", name);
            editor.putString("Username", username);
            editor.putString("Password", password);
            editor.apply();

            // Show a success message
            Toast.makeText(requireContext(), "Registration successful.", Toast.LENGTH_SHORT).show();

            // Navigate to the LoginFragment
            navigateToLoginFragment();
        }
    }

    private void navigateToLoginFragment() {
        // Create a new instance of the LoginFragment
        LoginFragment loginFragment = new LoginFragment();

        // Use a FragmentTransaction to replace the current fragment with the LoginFragment
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .addToBackStack(null) // Add to back stack for navigation
                .commit();
    }
}
