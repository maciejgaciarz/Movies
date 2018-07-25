package com.learning.mgaciarz.movies.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.learning.mgaciarz.movies.adapters.MovieAdapter;
import com.learning.mgaciarz.movies.R;
import com.learning.mgaciarz.movies.api.Downloader;
import com.learning.mgaciarz.movies.models.JSONResult;
import com.learning.mgaciarz.movies.models.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list_activity);


        Callback<JSONResult> responseCallback = new Callback<JSONResult>() {
            @Override
            public void onResponse(Call<JSONResult> call, Response<JSONResult> response) {

                Toast.makeText(getApplicationContext(), "OnReponseSuccess",
                        Toast.LENGTH_SHORT).show();


                JSONResult jsonResult = response.body();


                if (jsonResult != null) {
                    movies = new ArrayList<>(jsonResult.getResults());
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "jsonResult = response.body() is null",
                            Toast.LENGTH_SHORT).show();
                }

                mRecyclerView = findViewById(R.id.movies_recycler_main);
                mLayoutManager = new LinearLayoutManager(getApplicationContext());

                mRecyclerView.setLayoutManager(mLayoutManager);

                mAdapter = new MovieAdapter(movies, getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JSONResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "OnReponseFailed " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        };
        new Downloader(getApplicationContext()).getMoviesService().getPopularMovies().enqueue(responseCallback);

    }
}
