package com.example.app_nhac.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_nhac.Adapter.Adapter_Album;
import com.example.app_nhac.Adapter.Adapter_Album_Nhac;
import com.example.app_nhac.Adapter.Adapter_TheLoai_Nhac;
import com.example.app_nhac.R;
import com.example.app_nhac.RecycleViewDecoration.SpaceItemDecoration;
import com.example.app_nhac.model.baihat;

import java.util.ArrayList;

public class Album_NhacActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    Adapter_Album_Nhac adapter_album_Nhac;
    ArrayList<baihat> item_BaiHatArrayList;

    String DATABASE_NAME="My_music.db";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_album_nhac);

        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void init(){
        item_BaiHatArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv_Album_Nhac);
        Intent intent = getIntent();
        int idAlbum = intent.getIntExtra("idAlbum", -1);
        System.out.println(idAlbum);
        String tenalbum = intent.getStringExtra("album");
        toolbar = findViewById(R.id.toolbarAlbum_Nhac);
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(tenalbum);

        Cursor cursor = database.query("baihat", null, "idalbum=?", new String[]{String.valueOf(idAlbum)}, null, null, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            int idbaihat =cursor.getInt(0);
            int idalbum =cursor.getInt(1);
            int idtheloai=cursor.getInt(2);
            int idplaylist=cursor.getInt(3);
            String tenbaihat=cursor.getString(4);
            byte[] hinhbaihat=cursor.getBlob(5);
            System.out.println("this is for debug");
            String casi=cursor.getString(6);
            String linkbaihat=cursor.getString(7);
            System.out.println(tenbaihat);
            item_BaiHatArrayList.add(new baihat(idbaihat,idalbum,idtheloai,idplaylist,tenbaihat,casi,linkbaihat,hinhbaihat));
            cursor.moveToNext();
        }
        cursor.close();
        adapter_album_Nhac = new Adapter_Album_Nhac(this, item_BaiHatArrayList);
        int spaceInPixels = getResources().getDimensionPixelSize(R.dimen.space_between_items);
        recyclerView.addItemDecoration(new SpaceItemDecoration(spaceInPixels, this));
        //recyclerView.addItemDecoration(new SpaceItemDecoration(spaceInPixels, this));
        recyclerView.setLayoutManager(new GridLayoutManager(Album_NhacActivity.this,1));
        recyclerView.setAnimation(null);
        recyclerView.setAdapter(adapter_album_Nhac);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}