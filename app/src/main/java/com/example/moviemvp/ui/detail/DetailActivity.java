package com.example.moviemvp.ui.detail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviemvp.R;
import com.example.moviemvp.data.server.model.Detail;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements DetailMVPView {

    @BindView(R.id.imageDetail) ImageView poster;
    @BindView(R.id.detailFavorite) ImageView movieFavorited;
    @BindView(R.id.detailName) TextView movieTitle;
    @BindView(R.id.detailGenre) TextView movieGenre;
    @BindView(R.id.detailYear) TextView movieYear;
    @BindView(R.id.detailRating) TextView movieRating;
    @BindView(R.id.movie_desc) TextView moviePlot;
    @BindView(R.id.detailTime) TextView movieRunTime;
    @BindView(R.id.toolbar) Toolbar toolbar;

    boolean isFavored = false;
    String movieID = "";
    private String TAG ="detail_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Context context = DetailActivity.this;
        final DetailPresenter mPresenter = new DetailPresenter(this);

        mPresenter.mDataManager.setupPreference(context,getString(R.string.preference_movieMVP));

        mPresenter.detailMVPView.setToolbar();

        if (getIntent().getExtras() != null && getIntent().getExtras().getString("movieID") != null) {
            movieID = getIntent().getExtras().getString("movieID");
            mPresenter.showFilmDetail(movieID);
            isFavored = mPresenter.mDataManager.preferenceHelper.getBoolean(movieID);
            mPresenter.viewStar(isFavored);
            movieFavorited.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.setFavorite(movieID,isFavored);
                }
            });
        }

        Log.d(TAG, "onCreate2 ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy2");
    }

    @Override
    public void setContentView(Response<Detail> response) {
        movieTitle.setText(response.body().title);
        movieGenre.setText(response.body().genre);
        movieYear.setText(response.body().year);
        movieRating.setText(response.body().rating);
        moviePlot.setText(response.body().plot);
        movieRunTime.setText(" - " + response.body().runtime);
        Picasso.get()
                .load(response.body().imageURL)
                .into(poster);
        toolbar.setTitle(response.body().title); //set title
    }

    @Override
    public void viewToast(String message) {
        Toast.makeText(DetailActivity.this,message, Toast.LENGTH_SHORT).show(); //popup msg
    }

    @Override
    public void buildStar(boolean isFavored) {
        movieFavorited.setImageResource(isFavored ? R.drawable.ic_star_black_24dp : R.drawable.ic_star_border_black_24dp); //in line
    }

    @Override
    public void setIsFavored(boolean b) {
        isFavored = b;
    }

    @Override
    public void setToolbar() {
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true); //title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //tombol back
        getSupportActionBar().setDisplayShowHomeEnabled(true); //tombol back

        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleTypeface(Typeface.DEFAULT_BOLD);
    }

}
