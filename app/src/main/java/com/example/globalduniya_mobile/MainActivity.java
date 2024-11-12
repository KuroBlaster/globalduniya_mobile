package com.example.globalduniya_mobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.globalduniya_mobile.Tour;
import com.example.globalduniya_mobile.TourCarouselAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewPager2
        ViewPager2 tourCarousel = findViewById(R.id.tourCarousel);

        // Hardcoded data for tours
        List<Tour> tourList = new ArrayList<>();
        tourList.add(new Tour("Beach Paradise", "Relax on the sunny beaches", 299.99, R.drawable.beach_image));
        tourList.add(new Tour("Mountain Adventure", "Explore breathtaking mountains", 499.99, R.drawable.mountain_image));
        tourList.add(new Tour("City Lights", "Enjoy the nightlife in the big city", 399.99, R.drawable.city_image));
        tourList.add(new Tour("Historical Sites", "Visit ancient ruins and museums", 199.99, R.drawable.history_image));

        // Set up the adapter
        TourCarouselAdapter adapter = new TourCarouselAdapter(tourList);
        tourCarousel.setAdapter(adapter);
    }
}
