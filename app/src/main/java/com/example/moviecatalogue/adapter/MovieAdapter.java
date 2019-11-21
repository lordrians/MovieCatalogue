package com.example.moviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.detailActivity;
import com.example.moviecatalogue.objek.Movie;
import com.example.moviecatalogue.objek.dtMovie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context mContext;
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
    public View getView(final int position, View view, final ViewGroup viewGroup) {
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

        holder.LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveData = new Intent(viewGroup.getContext(), detailActivity.class);
                Movie movie = new Movie();
                movie.setPoster((listMovie.get(position).getPoster()));
                movie.setJudul((listMovie.get(position).getJudul()));
                movie.setDurasi((listMovie.get(position).getDurasi()));
                movie.setGenre((listMovie.get(position).getGenre()));
                movie.setRilis((listMovie.get(position).getRilis()));
                movie.setRate((listMovie.get(position).getRate()));
                movie.setRatecount((listMovie.get(position).getRatecount()));
                movie.setShortdesc((listMovie.get(position).getShortdesc()));
                movie.setSinopsis((listMovie.get(position).getSinopsis()));
                movie.setTrailer((listMovie.get(position).getTrailer()));
                moveData.putExtra(detailActivity.EXTRA_MOVIE, movie);
                viewGroup.getContext().startActivity(moveData);
            }
        });

        return view;


    }



    static class ViewHolder {
        private TextView tvJudul, tvDurasi, tvGenre,
                tvRilis, tvRate, tvRatecount, tvShortdesc, tvSinopsis;
        private ImageView ivPoster;
        private LinearLayout LL;

        void ViewHolder(View view){
            tvJudul = view.findViewById(R.id.tvItemJudul);
            tvDurasi = view.findViewById(R.id.tvItemDurasi);
            tvGenre = view.findViewById(R.id.tvItemGenre);
            tvRilis = view.findViewById(R.id.tvItemRilis);
            tvRate = view.findViewById(R.id.tvItemRate);
            tvRatecount = view.findViewById(R.id.tvItemRateCount);
            tvShortdesc = view.findViewById(R.id.tvItemShortDesc);
            ivPoster = view.findViewById(R.id.ivPItemPoster);
            LL = view.findViewById(R.id.ItemMovie);
        }
    }
}
