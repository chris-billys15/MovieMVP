package com.example.moviemvp.ui.list;

import com.example.moviemvp.data.DataManager;
import com.example.moviemvp.data.server.model.Film;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPresenter {

    ListMVPView mMvpView; //connect MVPView dengan Presenter
    DataManager mDataManager;

    public ListPresenter(ListMVPView listMVPView) {
        this.mMvpView= listMVPView;
        mDataManager = new DataManager();
    }

    public void filterByText(String key, String query) {
        mDataManager.getTopRatedMovies(key, query).enqueue(new Callback<Film.ListFilm>() {
            @Override
            public void onResponse(Call<Film.ListFilm> call, Response<Film.ListFilm> response) {
                if(response != null && response.body()!= null){
                    ArrayList<Film> movies = response.body().movieList;

                    if(response.body().response.equalsIgnoreCase("True")){
                        mMvpView.onSucceedGetResult(movies); //setup RecyclerView
                    }
                    else{
                        mMvpView.viewToast(response.body().message); //show Toast
                    }
                }
                else{
                    mMvpView.viewToast("response null");
                }
            }

            @Override
            public void onFailure(Call<Film.ListFilm> call, Throwable t) {
                mMvpView.viewToast("Error"); //show Toast
            }
        });
    }
}
