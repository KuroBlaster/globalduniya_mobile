package com.example.globalduniya_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DURATION = 800; // Splash duration in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.splashLogo);

        // Create a scaling animation for the logo
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0.1f, 1.0f,  // Start and end scale X
                0.1f, 1.0f,  // Start and end scale Y
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(SPLASH_DURATION);  // Set animation duration
        scaleAnimation.setFillAfter(true);  // Keep final state after animation
        logo.startAnimation(scaleAnimation);

        // Start MainActivity after the animation is done
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();  // Close SplashActivity so the user cannot go back to it
        }, SPLASH_DURATION);
    }
}
