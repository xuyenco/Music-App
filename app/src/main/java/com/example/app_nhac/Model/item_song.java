package com.example.app_nhac.Model;

import android.graphics.Bitmap;

public class item_song {
    int id;
    String tentg,tenbh;
    int image;



    public item_song(int id, String tentg, String tenbh, int image) {
        this.id=id;
        this.tentg = tentg;
        this.tenbh = tenbh;
        this.image = image;
    }

    public String getTentg() {
        return tentg;
    }

    public void setTentg(String tentg) {
        this.tentg = tentg;
    }

    public String getTenbh() {
        return tenbh;
    }

    public void setTenbh(String tenbh) {
        this.tenbh = tenbh;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
