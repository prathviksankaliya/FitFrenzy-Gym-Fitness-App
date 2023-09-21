package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;


public class FitnessItem {
    private int imageResId;
    private String title;
    private int calories;
    private String imageUrl;
    private String id; // Unique identifier for the item
    private boolean isDone;

    public FitnessItem(int imageResId, String title, int calories, String imageUrl) {
        this.imageResId = imageResId;
        this.title = title;
        this.calories = calories;
        this.imageUrl = imageUrl;
        // Other constructor code
        this.isDone = false;
    }


    public int getImageResId() {
        return imageResId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }




    public String getTitle() {
        return title;
    }



    public String getImageUrl() {
        return imageUrl; // Getter for imageUrl
    }
    public int getCalories() {
        return calories;
    }

    // Method to save FitnessItem to SharedPreferences
    public void saveToSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("FitnessItemPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("imageResId", imageResId);
        editor.putString("title", title);
        editor.putInt("calories", calories);
        editor.putBoolean("isDone", isDone);
        editor.apply();
    }

    // Method to load FitnessItem from SharedPreferences
    // Method to load FitnessItem from SharedPreferences
    public static FitnessItem loadFromSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("FitnessItemPrefs", Context.MODE_PRIVATE);
        int imageResId = sharedPreferences.getInt("imageResId", 0); // 0 is a default value
        String title = sharedPreferences.getString("title", "");
        int calories = sharedPreferences.getInt("calories", 0);
        boolean isDone = sharedPreferences.getBoolean("isDone", false);
        String imageUrl = sharedPreferences.getString("imageUrl", ""); // Retrieve imageUrl

        FitnessItem fitnessItem = new FitnessItem(imageResId, title, calories, imageUrl); // Pass imageUrl to constructor
        fitnessItem.setDone(isDone);
        return fitnessItem;
    }

}
