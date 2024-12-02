package com.example.globalduniya_mobile;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    // Class-level variable to store the list of tours
    private List<Tour> tours = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewPager2 and Adapter
        ViewPager2 tourCarousel = findViewById(R.id.tourCarousel);
        TourCarouselAdapter adapter = new TourCarouselAdapter(tours, this);
        tourCarousel.setAdapter(adapter);

        // Fetch tours and update the adapter when data is available
        fetchTours(adapter);

        // Hardcoded data for tours
        List<Tour> tourList = new ArrayList<>();
        /*tourList.add(new Tour(
                "Beach Paradise",
                "Relax on the sunny beaches",
                299.99,
                R.drawable.beach_image,
                "A relaxing beach vacation with beautiful views.",
                "Meals, Beach Activities, Guided Tours",
                "Departs every Saturday from Miami",
                "Day 1: Arrival, Day 2: Beach activities, Day 3: City tour",
                "Amazing experience! Highly recommend for anyone looking to relax by the beach.",
                25.7617, -80.1918 // Miami coordinates (example)
        ));

        // Sample Tour 2
        tourList.add(new Tour(
                "Mountain Adventure",
                "Climb the highest peaks",
                499.99,
                R.drawable.mountain_image,
                "An adventure-filled tour to conquer the highest mountains.",
                "Equipment, Meals, Guide",
                "Departs every Sunday from Denver",
                "Day 1: Introduction, Day 2-3: Mountain trekking, Day 4: Return",
                "A thrilling adventure with stunning views and challenges.",
                39.7392, -104.9903 // Denver coordinates (example)
        ));

        // Sample Tour 3
        tourList.add(new Tour(
                "City Lights Tour",
                "Explore the bright lights of the big city",
                199.99,
                R.drawable.city_image,
                "A vibrant tour to explore the nightlife and cultural hotspots of the city.",
                "City passes, Guided tours, Night activities",
                "Departs every Friday evening from New York City",
                "Day 1: Evening city tour, Day 2: Museum visits, Day 3: Broadway show",
                "A perfect blend of culture and entertainment!",
                40.7128, -74.0060 // New York City coordinates (example)
        ));

        // Sample Tour 4
        tourList.add(new Tour(
                "Historical Europe Tour",
                "Step back in time and explore Europe's rich history",
                1299.99,
                R.drawable.city_image,
                "A tour of Europe's most historic cities and landmarks.",
                "Accommodation, Meals, Entrance fees",
                "Departs every month from London",
                "Day 1: London sightseeing, Day 2: Paris visit, Day 3-4: Rome exploration",
                "An educational and unforgettable journey through history.",
                51.5074, -0.1278 // London coordinates (example)
        ));
        */
        ViewPager2 textCarousel = findViewById(R.id.textCarousel);

        List<Pair<String, String>> carouselData = Arrays.asList(
                new Pair<>("Destination Specialist", "With over 6 years of experience operating tours to Whistler and Victoria and being based in Vancouver, we have become experts in these destinations.With over 6 years of experience operating tours to Whistler and Victoria and being based in Vancouver, we have become experts in these destinations."),
                new Pair<>("Safety", "Safety is our top priority. In recognition of our stringent safety protocols, our clients and vendors are very satisfied."),
                new Pair<>("Guided Tours", "Each of our day and multiday tours are guided by a friendly, experienced and knowledgable tour guide. They will impart their love of Canada unto you."),
                new Pair<>("Customizable Itinerary", "Even though we have created a very enjoyable itinerary, we provide you with the ability to customize.")
        );

        TextCarouselAdapter adapter2 = new TextCarouselAdapter(carouselData);
        textCarousel.setAdapter(adapter2);


    }

    public void fetchTours (TourCarouselAdapter adapter) {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        Call<ApiResponse> call = apiService.getHotDeals();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse apiResponse = response.body();
                    if (apiResponse.isStatus()) {
                        tours.clear(); // Clear existing data
                        tours.addAll(apiResponse.getData()); // Add new data

                        // Notify the adapter that data has changed
                        adapter.notifyDataSetChanged();

                        Log.d(TAG, "Tours fetched successfully!");
                    } else {
                        Log.e(TAG, "API Error: " + apiResponse.getMessage());
                        Toast.makeText(MainActivity.this, "Error: " + apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String errorBody = response.errorBody() != null ? response.errorBody().string() : "Unknown error";
                        Log.e(TAG, "Response Error: " + errorBody);
                        Toast.makeText(MainActivity.this, "Server Error: " + errorBody, Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e(TAG, "Error reading errorBody: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e(TAG, "API Call Failed: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Failed to fetch data. Check your connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
