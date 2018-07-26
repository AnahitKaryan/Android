package com.example.arman.movie;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> movieList;
    private boolean isLiked = false;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                view.getContext().startActivity(browserIntent);
            }
        });
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Movie movie = movieList.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.image.setImageResource(movie.getImageId());
        holder.tvDescription.setText(movie.getDescription());
        holder.ratingBar.setRating(movie.getRating());
        holder.btnHeart.setMaxWidth(50);
        holder.btnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isLiked) {
                    holder.btnHeart.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                    isLiked = true;
                } else {
                    holder.btnHeart.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
                    isLiked = false;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public ImageView image;
        public TextView tvDescription;
        public RatingBar ratingBar;
        public ImageButton btnHeart;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            image = itemView.findViewById(R.id.img);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ratingBar = itemView.findViewById(R.id.rating);
            btnHeart = itemView.findViewById(R.id.btn_heart);
        }
    }
}
