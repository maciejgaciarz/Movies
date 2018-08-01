package com.learning.mgaciarz.movies.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.learning.mgaciarz.movies.R;

public class MainActivity extends AppCompatActivity {


    Button searchButton;
    Button popularMoviesButton;
    EditText movieTitleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.searchButton);
        popularMoviesButton = findViewById(R.id.popularMoviesButton);
        movieTitleEditText = findViewById(R.id.movieTitleEditText);


        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                boolean keepOriginal = true;
                StringBuilder sb = new StringBuilder(end - start);
                for (int i = start; i < end; i++) {
                    char c = source.charAt(i);
                    if (isCharAllowed(c)) // put your condition here
                        sb.append(c);
                    else
                        keepOriginal = false;
                }
                if (keepOriginal)
                    return null;
                else {
                    if (source instanceof Spanned) {
                        SpannableString sp = new SpannableString(sb);
                        TextUtils.copySpansFrom((Spanned) source, start, sb.length(), null, sp, 0);
                        return sp;
                    } else {
                        return sb;
                    }
                }
            }

            private boolean isCharAllowed(char c) {
                return Character.isLetterOrDigit(c) || Character.isSpaceChar(c);
            }
        };

        movieTitleEditText.setFilters(new InputFilter[]{filter});


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(MainActivity.this, MovieListActivity.class);

                //EditText editText = findViewById(R.id.movieTitleEditText);

                //String movieName = editText.getText().toString();

                //intent.putExtra("movieName", movieName);

                //startActivity(intent);
            }
        });


        popularMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MovieListActivity.class);

                startActivity(intent);

            }
        });


    }
}
