package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private List<FitnessItem> fitnessItems; // Replace with your fitness data

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_item_layout, container, false);
        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize and set up the RecyclerView
        fitnessItems = getSampleFitnessItems(); // Load your fitness data
        cartAdapter = new CartAdapter(requireContext(), fitnessItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        cartRecyclerView.setLayoutManager(layoutManager);
        cartRecyclerView.setAdapter(cartAdapter);
    }

    // Replace this with your actual data loading logic
    private List<FitnessItem> getSampleFitnessItems() {
        List<FitnessItem> items = new ArrayList<>();

        // Sample fitness data
        items.add(new FitnessItem(R.drawable.splashdemo, "Push-Ups", 100));
        items.add(new FitnessItem(R.drawable.splashdemo, "Jumping Jacks", 150));
        items.add(new FitnessItem(R.drawable.splashdemo, "Plank", 75));
        items.add(new FitnessItem(R.drawable.splashdemo, "Squats", 120));

        return items;
    }

}