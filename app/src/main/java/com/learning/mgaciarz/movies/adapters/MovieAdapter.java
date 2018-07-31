package com.learning.mgaciarz.movies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.mgaciarz.movies.R;
import com.learning.mgaciarz.movies.RecyclerViewClickListener;
import com.learning.mgaciarz.movies.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private Context context;
    private static RecyclerViewClickListener itemListener;

    private String imageURL = "http://image.tmdb.org/t/p/w185/";

    public MovieAdapter(List<Movie> movies, Context mContext, RecyclerViewClickListener listener) {
        this.movies = movies;
        this.context = mContext;
        this.itemListener = listener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_item, null);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        Movie movie = movies.get(position);

        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewShortDesc.setText(movie.getOverview());

        String fullImageURL = imageURL + movie.getPosterPath();

        Picasso.get().load(fullImageURL).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getAdapterPosition());
        }
    }
}
