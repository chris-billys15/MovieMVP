package com.example.moviemvp.ui.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviemvp.R;
import com.example.moviemvp.data.server.model.Film;
import com.example.moviemvp.ui.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieRowAdapter extends RecyclerView.Adapter<MovieRowAdapter.ViewHolder> {
    private ArrayList<Film> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;
    //data is passed into the constructor
    MovieRowAdapter(Context context, ArrayList<Film> data){
        this.context = context;
        this.mInflater =LayoutInflater.from(this.context);
        this.mData = data;

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.film_row, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Film film  = mData.get(position);
        holder.filmTitle.setText(film.title);
        holder.filmType.setText(film.type);
        holder.filmYear.setText(film.year);
        holder.id = film.imdbID;
        Picasso.get()
                .load(film.poster)
                .into(holder.filmPoster);

        holder.filmButton.setOnClickListener(new View.OnClickListener() { //untuk mengecek aksi click pd mButtonGoto
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class); //untuk pindah ke activity 2
                Bundle bundle = new Bundle(); // passing sesuatu ke activity lain
                bundle.putString("movieID", holder.id); //assign key kepada bundle
                intent.putExtras(bundle); //masukin bundle ke dalam intent
                context.startActivity(intent); //activity 1 bakal nunggu hasil return dari activity 2
            }
        });
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    public void updateList(ArrayList<Film> movies) {
        mData = movies;
        notifyDataSetChanged();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView filmTitle;
        TextView filmType;
        TextView filmYear;
        ImageView filmPoster;
        Button filmButton;
        String id;

        ViewHolder(View itemView) {
            super(itemView);
            filmTitle = itemView.findViewById(R.id.movieName);
            filmType = itemView.findViewById(R.id.movieType);
            filmYear = itemView.findViewById(R.id.movieYear);
            filmPoster = itemView.findViewById(R.id.movieImage);
            filmButton = itemView.findViewById(R.id.detailButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
                //pindah ke detail
                Intent intent = new Intent(context, DetailActivity.class); //untuk pindah ke activity 2
                Bundle bundle = new Bundle(); // passing sesuatu ke activity lain
                bundle.putString("movieID", id); //assign key kepada bundle
                intent.putExtras(bundle); //masukin bundle ke dalam intent
                context.startActivity(intent); //activity 1 bakal nunggu hasil return dari activity 2
            }
        }
    }

    // convenience method for getting data at click position
//    Search getItem(int id) {
//        return mData.get(id);
//    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}