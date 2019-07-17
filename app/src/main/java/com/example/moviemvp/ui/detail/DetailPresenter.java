package com.example.moviemvp.ui.detail;

import com.example.moviemvp.data.DataManager;
import com.example.moviemvp.data.server.model.Detail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    DetailMVPView detailMVPView;
    DataManager mDataManager;

    public DetailPresenter(DetailMVPView detailMVPView){
        this.detailMVPView = detailMVPView;
        mDataManager = new DataManager();
    }

    public void showFilmDetail(String id){
        mDataManager.getMovieDetails(id).enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response) {
                if(response.body().response.equalsIgnoreCase("True")){
                    detailMVPView.setContentView(response);
                }
                else{
                    detailMVPView.viewToast(response.body().message);
                }
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t) {
                detailMVPView.viewToast(t.getMessage());
            }
        });
    }

    public void viewStar(boolean isFavored) {
        if(isFavored){
            detailMVPView.buildStar(true);
        }
        else{
            detailMVPView.buildStar(false);
        }
    }

    public void setFavorite(String movieID, boolean isFavored) {
            detailMVPView.setIsFavored(!isFavored);
            detailMVPView.buildStar(!isFavored);
            mDataManager.setFavorite(movieID,isFavored);
    }
}