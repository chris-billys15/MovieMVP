package com.example.moviemvp.ui.detail;

import com.example.moviemvp.data.server.model.Detail;

import retrofit2.Response;

public interface DetailMVPView {

    void setContentView(Response<Detail> response);

    void viewToast(String message);

    void buildStar(boolean isFavored);

    void setIsFavored(boolean b);

    void setToolbar();
}
