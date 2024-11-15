package com.example.globalduniya_mobile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class TourDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView tourName, tourDescription, tourPrice, longDescription;
    private ImageView tourImage;
    private MapView mapView;
    private GoogleMap googleMap;

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

        // Initialize the MapView
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // Add a marker and move the camera
        LatLng tourLocation = new LatLng(49.2827, - 123.1207); // Example coordinates (Sydney)
        googleMap.addMarker(new MarkerOptions().position(tourLocation).title("Tour Location"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tourLocation, 14));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
