package com.example.app_nhac.model;

public class playlist {
    int idplaylist;
    String ten;
    byte[] hinhnen;
    byte[] hinhicon;

    public playlist(int idplaylist, String ten, byte[] hinhnen, byte[] hinhicon) {
        this.idplaylist = idplaylist;
        this.ten = ten;
        this.hinhnen = hinhnen;
        this.hinhicon = hinhicon;
    }

    public int getIdplaylist() {
        return idplaylist;
    }

    public void setIdplaylist(int idplaylist) {
        this.idplaylist = idplaylist;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public byte[] getHinhnen() {
        return hinhnen;
    }

    public void setHinhnen(byte[] hinhnen) {
        this.hinhnen = hinhnen;
    }

    public byte[] getHinhicon() {
        return hinhicon;
    }

    public void setHinhicon(byte[] hinhicon) {
        this.hinhicon = hinhicon;
    }
}
