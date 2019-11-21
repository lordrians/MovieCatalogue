package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviecatalogue.objek.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class detailActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
    public static final String EXTRA_MOVIE = "extra_movie";

    private TextView tvJudul, tvDurasi, tvGenre,
            tvRilis, tvRate, tvRatecount, tvShortdesc, tvSinopsis;
    private ImageView ivPoster;
    public static final String DEVELOPER_KEY = "AIzaSyDZXFkri4TiPG7CwSElJSk-mzyWHuHXUEE";
    public String VIDEO_ID;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    YouTubePlayerFragment myYouTubePlayerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        PaketData(movie);

        myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubePlayerView);
        myYouTubePlayerFragment.initialize(DEVELOPER_KEY, this);


    }
    public void PaketData(Movie movie){
        tvJudul = findViewById(R.id.tvDetailJudul);
        tvDurasi = findViewById(R.id.tvDetailDurasi);
        tvGenre = findViewById(R.id.tvDetailGenre);
        tvRilis = findViewById(R.id.tvDetailRilis);
        tvRate = findViewById(R.id.tvDetailRate);
        tvRatecount = findViewById(R.id.tvDetailRateCount);
        tvShortdesc = findViewById(R.id.tvDetailShortDesc);
        tvSinopsis = findViewById(R.id.tvDetailSinopsis);
        ivPoster = findViewById(R.id.ivDetailPoster);

        Glide.with(getApplicationContext())
                .load(movie.getPoster())
                .apply(new RequestOptions().centerCrop())
                .into(ivPoster);
        tvJudul.setText(movie.getJudul());
        tvDurasi.setText(movie.getDurasi());
        tvGenre.setText(movie.getGenre());
        tvRilis.setText(movie.getRilis());
        tvRate.setText(movie.getRate());
        tvRatecount.setText(movie.getRatecount());
        tvShortdesc.setText(movie.getShortdesc());
        tvSinopsis.setText(movie.getSinopsis());
        VIDEO_ID = movie.getTrailer();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView)findViewById(R.id.youtubePlayerView);
    }
}


