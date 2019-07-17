package com.example.moviemvp.ui.list;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviemvp.R;
import com.example.moviemvp.data.server.model.Film;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements ListMVPView, MovieRowAdapter.ItemClickListener{
    private String TAG = "MainActivity";

    @BindView(R.id.searchBar)EditText mEditText;
    @BindView(R.id.listFilm)RecyclerView mRecyclerView;
    ListPresenter mPresenter;
    MovieRowAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        mPresenter = new ListPresenter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new MovieRowAdapter(ListActivity.this, new ArrayList<Film>());
        mAdapter.setClickListener(ListActivity.this);
        mRecyclerView.setAdapter(mAdapter);

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String query = mEditText.getText().toString();
                    mPresenter.filterByText(getString(R.string.api_key),query);
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy1");
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: " + position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onSucceedGetResult(ArrayList<Film> movies) {
        mAdapter.updateList(movies);
    }

    @Override
    public void viewToast(String message) {
        Toast.makeText(ListActivity.this, message,Toast.LENGTH_SHORT).show();
    }
}
