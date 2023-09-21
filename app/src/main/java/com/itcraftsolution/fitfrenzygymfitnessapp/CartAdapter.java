package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bumptech.glide.Glide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<FitnessItem> fitnessItems;
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
        // Use Glide to load the online .gif image into the ImageView
        Glide.with(context)
                .load(item.getImageUrl()) // Load the .gif image from the URL
                .into(holder.fitnessImageView); // Display it in the ImageView

        holder.fitnessTitleTextView.setText(item.getTitle());
        holder.caloriesGainTextView.setText("Calories Gain: " + item.getCalories());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click here
                // Save the clicked item to SharedPreferences
                item.saveToSharedPreferences(context);

                // Open the FitnessDetailsActivity
                Intent intent = new Intent(context, FitnessDetailsActivity.class);
                context.startActivity(intent);
            }
        });
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
