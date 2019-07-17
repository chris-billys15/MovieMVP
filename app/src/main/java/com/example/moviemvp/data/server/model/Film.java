package com.example.moviemvp.data.server.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Film {

    @SerializedName("Title")
    public String title;
    @SerializedName("Year")
    public String year;
    @SerializedName("imdbID")
    public String imdbID;
    @SerializedName("Type")
    public String type;
    @SerializedName("Poster")
    public String poster;

    public class ListFilm{ //arrayList of Film
        @SerializedName("Search")
        public ArrayList<Film> movieList = new ArrayList<>();
        @SerializedName("totalResults")
        public String totalMovie;
        @SerializedName("Response")
        public String response;
        @SerializedName("Error")
        public String message;
    }
}