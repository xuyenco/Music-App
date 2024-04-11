package com.example.app_nhac.model;

import android.media.Image;

import java.io.Serializable;

public class AudioModel implements Serializable {
    String path;
    String title;
    String duration;
    byte[] Image;
    String Singer;

    public AudioModel() {
    }
    public AudioModel(String path, String title, String duration) {
        this.path = path;
        this.title = title;
        this.duration = duration;
    }
    public AudioModel(String path, String title, String duration, byte[] Image, String Singer) {
        this.path = path;
        this.title = title;
        this.duration = duration;
        this.Image = Image;
        this.Singer = Singer;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
