package com.example.moviemvp.ui.list;

import com.example.moviemvp.data.server.model.Film;

import java.util.ArrayList;

public interface ListMVPView {

    void onSucceedGetResult(ArrayList<Film> movies);

    void viewToast(String message);
}
