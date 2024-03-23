package com.example.app_nhac.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.app_nhac.Model.TopBXH;
import com.example.app_nhac.R;

public class DanhsachbaihatActivity extends AppCompatActivity {
    TopBXH item_song;
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
                item_song = (TopBXH) intent.getSerializableExtra("qc");
                Toast.makeText(this, item_song.getTenbh(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}