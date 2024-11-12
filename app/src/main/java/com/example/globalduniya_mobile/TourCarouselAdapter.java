package com.example.globalduniya_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TourCarouselAdapter extends RecyclerView.Adapter<TourCarouselAdapter.TourViewHolder> {

    private List<Tour> tourList;

    public TourCarouselAdapter(List<Tour> tourList) {
        this.tourList = tourList;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tour_carousel_item, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);
        holder.tourName.setText(tour.getName());
        holder.tourDescription.setText(tour.getDescription());
        holder.tourPrice.setText("$" + tour.getPrice());
        holder.tourImage.setImageResource(tour.getImageResId());
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
