package com.learning.mgaciarz.movies;

import android.view.View;

//interface to track a clicked position on a list
public interface RecyclerViewClickListener {
    public void recyclerViewListClicked(View v, int position);
}