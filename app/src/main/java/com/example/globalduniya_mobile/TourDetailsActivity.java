package com.example.globalduniya_mobile;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TourDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView tourName, tourDescription, tourPrice, longDescription, tourInclusions, tourDepartureDetails, tourItinerary, tourTestimonials;
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
        tourImage = findViewById(R.id.tourDetailImage);
        //tourInclusions = findViewById(R.id.tourInclusions);
        //tourItinerary = findViewById(R.id.tourItinerary);
        //tourTestimonials = findViewById(R.id.tourTestimonials);


        // Get data from Intent
        String name = getIntent().getStringExtra("tourName");
        String description = getIntent().getStringExtra("tourDescription");
        double price = getIntent().getDoubleExtra("tourPrice", 0);
        String image = getIntent().getStringExtra("tourImage"); // Image URL
        //String inclusions = getIntent().getStringExtra("tourInclusions");
        //String itinerary = getIntent().getStringExtra("tourItinerary");
        //String testimonials = getIntent().getStringExtra("tourTestimonials");
        String tourCode = getIntent().getStringExtra("tourCode");

        // Set data to views
        tourName.setText(name);
        tourDescription.setText(Html.fromHtml(description));
        tourPrice.setText("$" + price);
       // tourInclusions.setText(inclusions);
        //tourItinerary.setText(itinerary);
        //tourTestimonials.setText(testimonials);

        // Load image using Glide
        Glide.with(this)
                .load("https://globalduniya.ca/uploads/tours/gallery/" +tourCode + "/" + image) // URL of the image
                .placeholder(R.drawable.beach_image) // Placeholder image
                .error(R.drawable.ic_launcher_background) // Error image
                .into(tourImage);

        // Initialize the MapView
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // Add a marker and move the camera
        LatLng tourLocation = new LatLng(49.2827, -123.1207); // Example coordinates
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
