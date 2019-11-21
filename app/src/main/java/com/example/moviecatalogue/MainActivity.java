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

    }


    @Override
    public void onClick(View v) {

    }
}
