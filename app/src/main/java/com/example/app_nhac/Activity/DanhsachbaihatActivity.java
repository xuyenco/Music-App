package com.example.app_nhac.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.example.app_nhac.R;
import com.example.app_nhac.model.baihat;

public class DanhsachbaihatActivity extends AppCompatActivity {
    baihat item_song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        DateIntent();
    }

    private void DateIntent() {
        Intent intent=new Intent();
        if (intent!=null){
            if (intent.hasExtra("qc")){
                item_song = (baihat) intent.getSerializableExtra("qc");
                Toast.makeText(this, item_song.getTenbaihat(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}