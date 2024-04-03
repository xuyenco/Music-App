package com.example.app_nhac.model;

public class album {
    int idalbum;
    String tenalbum,tencasialbum;
    byte[] hinhalbum;

    public album(int idalbum, String tenalbum, String tencasialbum, byte[] hinhalbum) {
        this.idalbum = idalbum;
        this.tenalbum = tenalbum;
        this.tencasialbum = tencasialbum;
        this.hinhalbum = hinhalbum;
    }

    public int getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(int idalbum) {
        this.idalbum = idalbum;
    }

    public String getTenalbum() {
        return tenalbum;
    }

    public void setTenalbum(String tenalbum) {
        this.tenalbum = tenalbum;
    }

    public String getTencasialbum() {
        return tencasialbum;
    }

    public void setTencasialbum(String tencasialbum) {
        this.tencasialbum = tencasialbum;
    }

    public byte[] getHinhalbum() {
        return hinhalbum;
    }

    public void setHinhalbum(byte[] hinhalbum) {
        this.hinhalbum = hinhalbum;
    }
}
