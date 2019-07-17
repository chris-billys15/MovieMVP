package com.example.moviemvp.data.server;

import com.example.moviemvp.data.server.model.Detail;
import com.example.moviemvp.data.server.model.Film;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("?")
    Call<Film.ListFilm> getTopRatedMovies(@Query("apikey") String key, @Query("s") String search);

    @GET("?apikey=4f24b64f")
    Call<Detail> getMovieDetails(@Query("i") String id);
}
