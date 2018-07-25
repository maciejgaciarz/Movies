package com.learning.mgaciarz.movies.api;

import com.learning.mgaciarz.movies.models.JSONResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MoviesService {


    @GET("movie/popular")
    Call<JSONResult> getPopularMovies();

    @GET("search/movie")
    Call<JSONResult> getMovie(@Query("query") String query);


}






