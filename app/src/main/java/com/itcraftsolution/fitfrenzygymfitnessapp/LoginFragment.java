package com.itcraftsolution.fitfrenzygymfitnessapp;

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

                // Example: Check if username and password are empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(requireContext(), "Username and password are required.", Toast.LENGTH_SHORT).show();
                } else {
                    // Add your login logic here
                    // You can compare username and password with stored data or authenticate with a server
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
                        .replace(R.id.fragment_register,registrationFragment)
                        .addToBackStack(null) // Add to the back stack for back navigation
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}
