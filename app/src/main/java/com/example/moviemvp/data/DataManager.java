package com.example.moviemvp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.moviemvp.data.preference.PreferenceHelper;
import com.example.moviemvp.data.server.ApiInterface;
import com.example.moviemvp.data.server.model.Detail;
import com.example.moviemvp.data.server.model.Film;

import retrofit2.Call;

public class DataManager{
    public ApiInterface apiInterface;
    public PreferenceHelper preferenceHelper;
    public DataManager(){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }
    public void setupPreference(Context context,String preferenceName){
        preferenceHelper = new PreferenceHelper(context,preferenceName);
    }

    public Call<Film.ListFilm> getTopRatedMovies(String key, String search) {
        return apiInterface.getTopRatedMovies(key, search);
    }

    public Call<Detail> getMovieDetails (String ID){
        return apiInterface.getMovieDetails(ID);
    }

    public void setFavorite(String movieID, boolean isFavored){
        preferenceHelper.putBoolean(movieID,isFavored);
    }

}
