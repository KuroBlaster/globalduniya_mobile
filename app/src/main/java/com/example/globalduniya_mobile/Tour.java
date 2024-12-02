package com.example.globalduniya_mobile;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class Tour {

    // Existing fields
    private String title;
    private String description;
    private double price;
    private String image;
    private String longDescription;
    private String inclusions;
    private String departureDetails;
    private String itinerary;
    private String testimonials;
    private double latitude;
    private double longitude;

    // New fields from API
    @SerializedName("tour_code")
    private String tourCode;

    @SerializedName("stars")
    private double stars;

    @SerializedName("total_days")
    private int totalDays;

    @SerializedName("total_nights")
    private int totalNights;

    @SerializedName("total_reviews")
    private int totalReviews;

    @SerializedName("tour_duration")
    private String tourDuration;

    @SerializedName("exclusions")
    private String exclusions;

    @SerializedName("status")
    private String status;

    // Constructor to initialize the tour object
    public Tour(String title, String description, double price, String image, String longDescription,
                String inclusions, String departureDetails, String itinerary, String testimonials,
                double latitude, double longitude) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.longDescription = longDescription;
        this.inclusions = inclusions;
        this.departureDetails = departureDetails;
        this.itinerary = itinerary;
        this.testimonials = testimonials;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    // Constructor to initialize all fields
    public Tour(String title, String description, double price, String image, String longDescription,
                String inclusions, String departureDetails, String itinerary, String testimonials,
                double latitude, double longitude, String tourCode, double stars, int totalDays,
                int totalNights, int totalReviews, String tourDuration, String exclusions, String status) {
        // Existing fields
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.longDescription = longDescription;
        this.inclusions = inclusions;
        this.departureDetails = departureDetails;
        this.itinerary = itinerary;
        this.testimonials = testimonials;
        this.latitude = latitude;
        this.longitude = longitude;

        // New fields
        this.tourCode = tourCode;
        this.stars = stars;
        this.totalDays = totalDays;
        this.totalNights = totalNights;
        this.totalReviews = totalReviews;
        this.tourDuration = tourDuration;
        this.exclusions = exclusions;
        this.status = status;
    }

    // Getters and setters for existing fields
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImageResId(String image) {
        this.image = image;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getInclusions() {
        return inclusions;
    }

    public void setInclusions(String inclusions) {
        this.inclusions = inclusions;
    }

    public String getDepartureDetails() {
        return departureDetails;
    }

    public void setDepartureDetails(String departureDetails) {
        this.departureDetails = departureDetails;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public String getTestimonials() {
        return testimonials;
    }

    public void setTestimonials(String testimonials) {
        this.testimonials = testimonials;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Getters and setters for new fields
    public String getTourCode() {
        return tourCode;
    }

    public void setTourCode(String tourCode) {
        this.tourCode = tourCode;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getTotalNights() {
        return totalNights;
    }

    public void setTotalNights(int totalNights) {
        this.totalNights = totalNights;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public String getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(String tourDuration) {
        this.tourDuration = tourDuration;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString()
    @NonNull
    @Override
    public String toString() {
        return "Tour{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", tourCode='" + tourCode + '\'' +
                ", stars=" + stars +
                ", totalDays=" + totalDays +
                ", totalNights=" + totalNights +
                ", totalReviews=" + totalReviews +
                ", tourDuration='" + tourDuration + '\'' +
                ", inclusions='" + inclusions + '\'' +
                ", exclusions='" + exclusions + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }
}
