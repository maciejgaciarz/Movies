package com.learning.mgaciarz.movies.api;

import android.content.Context;

import com.learning.mgaciarz.movies.R;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Downloader {

    String API_KEY;

    public Downloader(Context context) {
        this.API_KEY = context.getResources().getString(R.string.api_key);
    }

    public IMoviesService getMoviesService( ) {

        //intercept the call to add api_key
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl httpUrl = original.url();

                        HttpUrl newHttpUrl = httpUrl.newBuilder()
                                .addQueryParameter("api_key", API_KEY)
                                .build();

                        Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);


                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).build();


        //build a retrofit API client
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IMoviesService service = retrofit.create(IMoviesService.class);

        return service;
    }




    private void getMovie(String name) {

        //intercept the call to add api_key
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl httpUrl = original.url();

                        HttpUrl newHttpUrl = httpUrl.newBuilder()
                                .addQueryParameter("api_key", API_KEY)
                                .build();

                        Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);


                        Request request = requestBuilder.build();
                        return chain.proceed(request);

                    }
                }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        IMoviesService service = retrofit.create(IMoviesService.class);

        service.getMovie(name);
    }


}