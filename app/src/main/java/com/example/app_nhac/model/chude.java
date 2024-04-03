package com.example.app_nhac.model;

public class chude {
    int idchude;
    String tenchude;
    byte[] Hinhchude;

    public chude(int idchude, String tenchude, byte[] hinhchude) {
        this.idchude = idchude;
        this.tenchude = tenchude;
        Hinhchude = hinhchude;
    }

    public int getIdchude() {
        return idchude;
    }

    public void setIdchude(int idchude) {
        this.idchude = idchude;
    }

    public String getTenchude() {
        return tenchude;
    }

    public void setTenchude(String tenchude) {
        this.tenchude = tenchude;
    }

    public byte[] getHinhchude() {
        return Hinhchude;
    }

    public void setHinhchude(byte[] hinhchude) {
        Hinhchude = hinhchude;
    }
}
