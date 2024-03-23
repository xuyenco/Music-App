package com.example.app_nhac.Model;

public class Album {
    int imagealbum;
    String tenbh,tentg;

    public Album(String tentg,String tenbh,int imagealbum  ) {
        this.imagealbum = imagealbum;
        this.tenbh = tenbh;
        this.tentg = tentg;
    }

    public int getImagealbum() {
        return imagealbum;
    }

    public void setImagealbum(int imagealbum) {
        this.imagealbum = imagealbum;
    }

    public String getTenbh() {
        return tenbh;
    }

    public void setTenbh(String tenbh) {
        this.tenbh = tenbh;
    }

    public String getTentg() {
        return tentg;
    }

    public void setTentg(String tentg) {
        this.tentg = tentg;
    }
}
