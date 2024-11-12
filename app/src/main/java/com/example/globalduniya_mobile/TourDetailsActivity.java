package com.example.globalduniya_mobile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TourDetailsActivity extends AppCompatActivity {

    private TextView tourName, tourDescription, tourPrice, longDescription;
    private ImageView tourImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_details);

        // Initialize UI elements
        tourName = findViewById(R.id.tourDetailName);
        tourDescription = findViewById(R.id.tourDetailDescription);
        tourPrice = findViewById(R.id.tourDetailPrice);
        longDescription = findViewById(R.id.tourLongDescription);
        tourImage = findViewById(R.id.tourDetailImage);

        // Get data from Intent
        String name = getIntent().getStringExtra("tourName");
        String description = getIntent().getStringExtra("tourDescription");
        double price = getIntent().getDoubleExtra("tourPrice", 0);
        int imageResId = getIntent().getIntExtra("tourImageResId", 0);
        String longDesc = getIntent().getStringExtra("tourLongDescription");

        // Set data to views
        tourName.setText(name);
        tourDescription.setText(description);
        tourPrice.setText("$" + price);
        longDescription.setText(longDesc);
        tourImage.setImageResource(imageResId);
    }
}
