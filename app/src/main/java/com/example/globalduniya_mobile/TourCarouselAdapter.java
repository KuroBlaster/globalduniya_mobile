package com.example.globalduniya_mobile;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class TourCarouselAdapter extends RecyclerView.Adapter<TourCarouselAdapter.TourViewHolder> {

    private List<Tour> tourList;
    private Context context;

    public TourCarouselAdapter(List<Tour> tourList, Context context) {
        this.tourList = tourList;
        this.context = context;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tour_carousel_item, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);
        holder.tourName.setText(tour.getTitle());
        // Render the HTML description
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tourDescription.setText(Html.fromHtml(tour.getDescription(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.tourDescription.setText(Html.fromHtml(tour.getDescription()));
        }
        holder.tourPrice.setText("$" + tour.getPrice());
        // Load image from URL using Glide
        Glide.with(context)
                .load("https://globalduniya.ca/uploads/tours/gallery/" +tour.getTourCode()+ "/" + tour.getImage()) // URL of the image
                .listener(new com.bumptech.glide.request.RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // Handle load failure if needed (optional)
                        holder.tourImage.setVisibility(View.GONE); // Hide the ImageView if the load fails
                        return false; // Pass false to let Glide handle the error placeholder
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        // Ensure the ImageView is visible
                        holder.tourImage.setVisibility(View.VISIBLE);
                        return false; // Pass false to let Glide display the image
                    }
                })
                .into(holder.tourImage);

        // Set click listener to navigate to the details page
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TourDetailsActivity.class);
            intent.putExtra("tourName", tour.getTitle());
            intent.putExtra("tourDescription", tour.getDescription());
            intent.putExtra("tourPrice", tour.getPrice());
            intent.putExtra("tourImage", tour.getImage());
            intent.putExtra("tourLongDescription", tour.getLongDescription());
            intent.putExtra("tourInclusions", tour.getInclusions());
            intent.putExtra("tourDepartureDetails", tour.getDepartureDetails());
            intent.putExtra("tourItinerary", tour.getItinerary());
            intent.putExtra("tourTestimonials", tour.getTestimonials());
            intent.putExtra("tourCode", tour.getTourCode());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    static class TourViewHolder extends RecyclerView.ViewHolder {
        TextView tourName, tourDescription, tourPrice;
        ImageView tourImage;

        public TourViewHolder(View itemView) {
            super(itemView);
            tourName = itemView.findViewById(R.id.tourName);
            tourDescription = itemView.findViewById(R.id.tourDescription);
            tourPrice = itemView.findViewById(R.id.tourPrice);
            tourImage = itemView.findViewById(R.id.tourImage);
        }
    }
}
