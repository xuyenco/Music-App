package com.example.app_nhac.model;

import java.sql.Blob;

public class baihat {
    int idbaihat,idalbum,idtheloai,idplaylist;
    String tenbaihat,casi,linkbaihat;
    byte[] hinhbaihat;

    public baihat() {
    }

    public baihat(int idbaihat, int idalbum, int idtheloai, int idplaylist, String tenbaihat, String casi, String linkbaihat, byte[] hinhbaihat) {
        this.idbaihat = idbaihat;
        this.idalbum = idalbum;
        this.idtheloai = idtheloai;
        this.idplaylist = idplaylist;
        this.tenbaihat = tenbaihat;
        this.casi = casi;
        this.linkbaihat = linkbaihat;
        this.hinhbaihat = hinhbaihat;
    }

    public int getIdbaihat() {
        return idbaihat;
    }

    public void setIdbaihat(int idbaihat) {
        this.idbaihat = idbaihat;
    }

    public int getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(int idalbum) {
        this.idalbum = idalbum;
    }

    public int getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(int idtheloai) {
        this.idtheloai = idtheloai;
    }

    public int getIdplaylist() {
        return idplaylist;
    }

    public void setIdplaylist(int idplaylist) {
        this.idplaylist = idplaylist;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public String getLinkbaihat() {
        return linkbaihat;
    }

    public void setLinkbaihat(String linkbaihat) {
        this.linkbaihat = linkbaihat;
    }

    public byte[] getHinhbaihat() {
        return hinhbaihat;
    }

    public void setHinhbaihat(byte[] hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }
}
