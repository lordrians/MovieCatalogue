package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.moviecatalogue.adapter.MovieAdapter;
import com.example.moviecatalogue.objek.Movie;
import com.example.moviecatalogue.objek.dtMovie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] dtJudul, dtDurasi, dtGenre, dtRilis, dtRate, dtRateCount, dtShortDesc, dtSinopsis, dtPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList alMovie = dtMovie.getData();
        ListView listView = (ListView) findViewById(R.id.lvMovie);
        listView.setAdapter(new MovieAdapter(this, alMovie));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent moveData = new Intent(MainActivity.this, detailActivity.class);
                Movie movie  = new Movie();
                movie.setJudul(dtJudul[position]);
                movie.setDurasi(dtDurasi[position]);
                movie.setGenre(dtGenre[position]);
                movie.setRilis(dtRilis[position]);
                movie.setRate(dtRate[position]);
                movie.setRatecount(dtRateCount[position]);
                movie.setShortdesc(dtShortDesc[position]);
                movie.setPoster(dtPoster[position]);
                movie.setSinopsis(dtSinopsis[position]);

                moveData.putExtra(detailActivity.EXTRA_MOVIE, movie);
                startActivity(moveData);

            }
        });
    }


    @Override
    public void onClick(View v) {

    }
}
