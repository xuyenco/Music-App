package com.example.app_nhac.Model;

import java.io.Serializable;

public class Quangcao implements Serializable {
    int imageqc;
    int imagebh;
    String tenbh,gioithieu;

    public Quangcao(int imageqc, int imagebh, String tenbh, String gioithieu) {
        this.imageqc = imageqc;
        this.imagebh = imagebh;
        this.tenbh = tenbh;
        this.gioithieu = gioithieu;
    }

    public int getImageqc() {
        return imageqc;
    }

    public void setImageqc(int imageqc) {
        this.imageqc = imageqc;
    }

    public int getImagebh() {
        return imagebh;
    }

    public void setImagebh(int imagebh) {
        this.imagebh = imagebh;
    }

    public String getTenbh() {
        return tenbh;
    }

    public void setTenbh(String tenbh) {
        this.tenbh = tenbh;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }
}
