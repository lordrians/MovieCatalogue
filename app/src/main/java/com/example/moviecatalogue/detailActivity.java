package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecatalogue.objek.Movie;

import java.util.ArrayList;

public class detailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    private TextView tvJudul, tvDurasi, tvGenre,
            tvRilis, tvRate, tvRatecount, tvShortdesc, tvSinopsis;
    private ImageView ivPoster;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.tvDetailJudul);
        tvDurasi = findViewById(R.id.tvDetailDurasi);
        tvGenre = findViewById(R.id.tvDetailGenre);
        tvRilis = findViewById(R.id.tvDetailRilis);
        tvRate = findViewById(R.id.tvDetailRate);
        tvRatecount = findViewById(R.id.tvDetailRateCount);
        tvShortdesc = findViewById(R.id.tvDetailShortDesc);
        tvSinopsis = findViewById(R.id.tvDetailSinopsis);
        ivPoster = findViewById(R.id.ivDetailPoster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tvJudul.setText(movie.getJudul());
        tvDurasi.setText(movie.getDurasi());
        tvGenre.setText(movie.getGenre());
        tvRilis.setText(movie.getRilis());
        tvRate.setText(movie.getRate());
        tvRatecount.setText(movie.getRatecount());
        tvShortdesc.setText(movie.getShortdesc());
        tvSinopsis.setText(movie.getSinopsis());
    }
}
