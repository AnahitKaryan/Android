package com.example.arman.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv_movie);
        fillMovieList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        MovieAdapter movieAdapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(movieAdapter);

    }

    private void fillMovieList() {
        Movie movie = new Movie("Movie1", R.drawable.ic_launcher_background,
                "Horror", 4, false, "google.com");
        movieList.add(movie);
        movie = new Movie("Movie2", R.drawable.ic_launcher_background,
                "Drama", 3, false, "facebook.com");
        movieList.add(movie);
        movie = new Movie("Movie3", R.drawable.ic_launcher_background,
                "Drama", 5, false, "google.ru");
        movieList.add(movie);
        movie = new Movie("Movie4", R.drawable.ic_launcher_background,
                "Drama", 2, false, "yandex.ru");
        movieList.add(movie);
    }
}
