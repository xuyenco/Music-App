package com.example.app_nhac.Model;

import androidx.databinding.Bindable;
import androidx.databinding.BaseObservable;

import com.example.app_nhac.BR;

import java.io.Serializable;

public class TopBXH  extends BaseObservable{
    int id;
    String tentg,tenbh;
    int image;


    public TopBXH(int id, String tentg, String tenbh, int image) {
        this.id = id;
        this.tentg = tentg;
        this.tenbh = tenbh;
        this.image = image;
    }
    @Bindable
    public String getTentg() {
        return tentg;
    }

    public void setTentg(String tentg) {
        this.tentg = tentg;
         notifyPropertyChanged(BR.tentg);

    }
    @Bindable
    public String getTenbh() {
        return tenbh;
    }

    public void setTenbh(String tenbh) {
        this.tenbh = tenbh;
        notifyPropertyChanged(BR.tenbh);
    }
    @Bindable
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }
    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
