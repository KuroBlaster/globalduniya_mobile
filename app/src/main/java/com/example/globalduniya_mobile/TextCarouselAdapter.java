package com.example.globalduniya_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TextCarouselAdapter extends RecyclerView.Adapter<TextCarouselAdapter.ViewHolder> {

    private final List<Pair<String, String>> data;

    public TextCarouselAdapter(List<Pair<String, String>> carouselData) {
        this.data = carouselData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_carousel_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pair<String, String> item = data.get(position);
        holder.subheadingText.setText(item.first);
        holder.descriptionText.setText(item.second);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView subheadingText;
        TextView descriptionText;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            subheadingText = itemView.findViewById(R.id.subheadingText);
            descriptionText = itemView.findViewById(R.id.descriptionText);
        }
    }
}
