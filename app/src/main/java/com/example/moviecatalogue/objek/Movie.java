package com.example.moviecatalogue.objek;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String judul;
    private String durasi;
    private String genre;
    private String rilis;
    private String rate;
    private String ratecount;
    private String shortdesc;
    private String sinopsis;
    private String poster;
    private String trailer;

    public Movie() {

    }


    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRatecount() {
        return ratecount;
    }

    public void setRatecount(String ratecount) {
        this.ratecount = ratecount;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getSinopsis() {
        return sinopsis;
    }


    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Movie(Parcel in) {
        judul = in.readString();
        durasi = in.readString();
        genre = in.readString();
        rilis = in.readString();
        rate = in.readString();
        ratecount = in.readString();
        shortdesc = in.readString();
        sinopsis = in.readString();
        poster = in.readString();
        trailer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(durasi);
        dest.writeString(genre);
        dest.writeString(rilis);
        dest.writeString(rate);
        dest.writeString(ratecount);
        dest.writeString(shortdesc);
        dest.writeString(sinopsis);
        dest.writeString(poster);
        dest.writeString(trailer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };


}
