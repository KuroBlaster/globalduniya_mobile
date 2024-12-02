package com.example.globalduniya_mobile;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitClient {
    private static final String BASE_URL = "https://globalduniya.ca/"; // Replace with your API base URL
    private static final String API_KEY = "bRZ9L8f8WJQFxEsJ5LnNOq0xQtv8WqixpmAUb79iYeM"; // Replace with your API key
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            // Add Interceptor for API Key
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();
                            Request request = original.newBuilder()
                                    .header("X-API-KEY", API_KEY)
                                    .method(original.method(), original.body())
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
