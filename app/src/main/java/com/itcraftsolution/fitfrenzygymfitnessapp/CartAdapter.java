package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<FitnessItem> fitnessItems; // Replace with your fitness data model
    private Context context;

    public CartAdapter(Context context, List<FitnessItem> fitnessItems) {
        this.context = context;
        this.fitnessItems = fitnessItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        FitnessItem item = fitnessItems.get(position);

        // Bind data to views
        holder.fitnessImageView.setImageResource(item.getImageResId());
        holder.fitnessTitleTextView.setText(item.getTitle());
        holder.caloriesGainTextView.setText("Calories Gain: " + item.getCalories());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click here
                openFitnessDetailFragment(item);
            }

            private void openFitnessDetailFragment(FitnessItem item) {
                FitnessDetailFragment detailFragment = new FitnessDetailFragment();

                // Pass the selected fitness item as an argument to the fragment
//                Bundle args = new Bundle();
//                args.putParcelable("selectedFitnessItem", fitnessItems);
//                detailFragment.setArguments(args);

                // Replace the current fragment with the FitnessDetailFragment
                FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, detailFragment);
                transaction.addToBackStack(null); // Add to back stack for navigation
                transaction.commit();
            }
        });
        // Implement any additional actions or listeners here if needed
    }

    @Override
    public int getItemCount() {
        return fitnessItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView fitnessImageView;
        TextView fitnessTitleTextView;
        TextView caloriesGainTextView;

        public CartViewHolder(View itemView) {
            super(itemView);
            fitnessImageView = itemView.findViewById(R.id.fitnessImageView);
            fitnessTitleTextView = itemView.findViewById(R.id.fitnessTitleTextView);
            caloriesGainTextView = itemView.findViewById(R.id.caloriesGainTextView);
        }
    }
    
}


