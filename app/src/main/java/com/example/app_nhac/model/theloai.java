package com.example.app_nhac.model;

public class theloai {
    int idtheloai,idchude;
    String tentheloai;
    byte[] hinhtheloai;

    public theloai(int idtheloai, int idchude, String tentheloai, byte[] hinhtheloai) {
        this.idtheloai = idtheloai;
        this.idchude = idchude;
        this.tentheloai = tentheloai;
        this.hinhtheloai = hinhtheloai;
    }

    public int getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(int idtheloai) {
        this.idtheloai = idtheloai;
    }

    public int getIdchude() {
        return idchude;
    }

    public void setIdchude(int idchude) {
        this.idchude = idchude;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public byte[] getHinhtheloai() {
        return hinhtheloai;
    }

    public void setHinhtheloai(byte[] hinhtheloai) {
        this.hinhtheloai = hinhtheloai;
    }
}
