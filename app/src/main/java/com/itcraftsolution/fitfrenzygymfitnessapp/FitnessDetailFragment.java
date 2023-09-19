package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FitnessDetailFragment extends Fragment {

    public FitnessDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fitness_detail, container, false);

        // Initialize views and populate with data
        ImageView fitnessImageView = view.findViewById(R.id.fitnessImageView);
        TextView fitnessTitleTextView = view.findViewById(R.id.fitnessTitleTextView);
        TextView fitnessDescriptionTextView = view.findViewById(R.id.fitnessDescriptionTextView);

        // Retrieve the selected fitness item data from arguments or wherever it's stored
        FitnessItem selectedFitnessItem = getArguments().getParcelable("selectedFitnessItem");

        // Populate views with data
        if (selectedFitnessItem != null) {
            fitnessImageView.setImageResource(selectedFitnessItem.getImageResId());
            fitnessTitleTextView.setText(selectedFitnessItem.getTitle());
            fitnessDescriptionTextView.setText(selectedFitnessItem.getDescription());
        }

        return view;
    }
}
