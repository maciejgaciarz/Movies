package com.learning.mgaciarz.movies.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.learning.mgaciarz.movies.IntentDebug;
import com.learning.mgaciarz.movies.R;
import com.learning.mgaciarz.movies.models.Movie;

import java.util.Iterator;
import java.util.Set;


public class SingleMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_movie_activity);


        //new IntentDebug().dumpIntent(getIntent(),"MojDumpLogow");

        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("clickedMovie")){
        Movie movie = bundle.getParcelable("clickedMovie");
        setTitle(movie.getTitle());

        }
        else{
            Intent i = new Intent(this,ErrorActivity.class);
            startActivity(i);
        }


    }
}