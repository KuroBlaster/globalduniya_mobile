package com.example.globalduniya_mobile;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/hot_deals_tour") // Your API endpoint
    Call<ApiResponse> getHotDeals();
}
