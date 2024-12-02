package com.example.globalduniya_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TourAdapter extends ArrayAdapter<Tour> {

    public TourAdapter(Context context, List<Tour> tours) {
        super(context, 0, tours);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tour_item, parent, false);
        }

        Tour tour = getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.tourName);
        TextView descriptionTextView = convertView.findViewById(R.id.tourDescription);
        TextView priceTextView = convertView.findViewById(R.id.tourPrice);

        nameTextView.setText(tour.getTitle());
        descriptionTextView.setText(tour.getDescription());
        priceTextView.setText("$" + tour.getPrice());

        return convertView;
    }
}
