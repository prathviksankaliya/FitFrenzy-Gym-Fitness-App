package com.itcraftsolution.fitfrenzygymfitnessapp;

public class FitnessItem {
    private int imageResId;
    private String title;
    private int calories;

    public FitnessItem(int imageResId, String title, int calories) {
        this.imageResId = imageResId;
        this.title = title;
        this.calories = calories;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getCalories() {
        return calories;
    }
}
