package com.example.app_nhac.model;

import android.net.Uri;

public class quangcao {
    int id;
    byte[] hinhanh;
    String noidung;
    int idbahat;
    String tenbaihat;


    public quangcao(int id, byte[] hinhanh, String noidung, int idbahat, String tenbaihat) {
        this.id = id;
        this.hinhanh = hinhanh;
        this.noidung = noidung;
        this.idbahat = idbahat;
        this.tenbaihat = tenbaihat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getIdbahat() {
        return idbahat;
    }

    public void setIdbahat(int idbahat) {
        this.idbahat = idbahat;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }
}
