package com.itcraftsolution.fitfrenzygymfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class FinishActivity extends AppCompatActivity {

    private static final int DELAY_TIME = 5000; // 5 seconds in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);

        // Set animation from the JSON file in res/raw
        animationView.setAnimation(R.raw.animation);

        // Start the animation
        animationView.playAnimation();

        // Use a Handler to delay the transition to HomeActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an intent to open the HomeActivity
                Intent intent = new Intent(FinishActivity.this, HomeActivity.class);
                startActivity(intent);

                // Finish the current activity (FinishActivity)
                finish();
            }
        }, DELAY_TIME);
    }
}
