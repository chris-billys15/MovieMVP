package com.example.moviemvp.data.server.model;

import com.google.gson.annotations.SerializedName;

public class Detail {
    @SerializedName("Title")
    public String title;
    @SerializedName("Year")
    public String year;
    @SerializedName("imdbRating")
    public String rating;
    @SerializedName("Runtime")
    public String runtime;
    @SerializedName("Genre")
    public String genre;
    @SerializedName("Plot")
    public String plot;
    @SerializedName("Response")
    public String response;
    @SerializedName("Error")
    public String message;
    @SerializedName("Poster")
    public String imageURL;
}
