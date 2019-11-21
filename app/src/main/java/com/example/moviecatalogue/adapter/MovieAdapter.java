package com.example.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.objek.Movie;
import com.example.moviecatalogue.objek.dtMovie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    //private final Context context;
    private ArrayList<Movie> listMovie;
    private LayoutInflater layoutInflater;
    public MovieAdapter(Context context, ArrayList<Movie> listMovie){
        this.listMovie = listMovie;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setMovies(ArrayList<Movie> movies ) {
        this.listMovie = movies;
    }

    @Override
    public int getCount() {
        return listMovie.size();
    }

    @Override
    public Object getItem(int position) {
        return listMovie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.item_movie, null);
            holder = new ViewHolder();
            holder.ViewHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(viewGroup.getContext())
                .load(listMovie.get(position).getPoster())
                .apply(new RequestOptions().centerCrop())
                .into(holder.ivPoster);

        holder.tvJudul.setText(listMovie.get(position).getJudul());
        holder.tvDurasi.setText(listMovie.get(position).getDurasi());
        holder.tvGenre.setText(listMovie.get(position).getGenre());
        holder.tvRilis.setText(listMovie.get(position).getRilis());
        holder.tvRate.setText(listMovie.get(position).getRate());
        holder.tvRatecount.setText(listMovie.get(position).getRatecount());
        holder.tvShortdesc.setText(listMovie.get(position).getShortdesc());

        return view;


    }

    static class ViewHolder {
        private TextView tvJudul, tvDurasi, tvGenre,
                tvRilis, tvRate, tvRatecount, tvShortdesc, tvSinopsis;
        private ImageView ivPoster;

        void ViewHolder(View view){
            tvJudul = view.findViewById(R.id.tvItemJudul);
            tvDurasi = view.findViewById(R.id.tvItemDurasi);
            tvGenre = view.findViewById(R.id.tvItemGenre);
            tvRilis = view.findViewById(R.id.tvItemRilis);
            tvRate = view.findViewById(R.id.tvItemRate);
            tvRatecount = view.findViewById(R.id.tvItemRateCount);
            tvShortdesc = view.findViewById(R.id.tvItemShortDesc);
            ivPoster = view.findViewById(R.id.ivPItemPoster);
        }
    }
}
