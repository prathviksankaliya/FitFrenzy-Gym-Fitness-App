package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashFragment extends Fragment {

    private static final long SPLASH_DURATION = 4000; // Splash screen duration in milliseconds

    public SplashFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        if (getActivity() != null) {
            getActivity().setTitle(""); // Set an empty title
        }
        // Use a Handler to delay the transition to the next fragment
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Replace the current fragment with the LoginFragment
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_register, new RegisterFragment());
                transaction.commit();
            }
        }, SPLASH_DURATION);

        return view;
    }
}


