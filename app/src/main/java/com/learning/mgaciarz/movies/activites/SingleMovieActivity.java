package com.learning.mgaciarz.movies.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.learning.mgaciarz.movies.R;
import com.learning.mgaciarz.movies.models.Movie;


public class SingleMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_movie_activity);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            Movie movie = bundle.getParcelable("clickedMovie");
            setTitle(movie.getTitle());
        }
        else{
            //todo: go to error screen "something went wrong please try again"
        }
    }
}