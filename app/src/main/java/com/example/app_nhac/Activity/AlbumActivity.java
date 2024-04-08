package com.example.app_nhac.Activity;

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
import com.example.app_nhac.R;
import com.example.app_nhac.RecycleViewDecoration.SpaceItemDecoration;
import com.example.app_nhac.model.album;


import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    Adapter_Album adapter_album;
    ArrayList<album> item_AlbumArrayList = new ArrayList<>();
    String DATABASE_NAME="My_music.db";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_album);

        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init(){
        recyclerView = findViewById(R.id.recyclerviewAlbum);
        toolbar = findViewById(R.id.toolbarAlbum);
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Album");

        Cursor cursor=database.query("album",null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){

            int idalbum=cursor.getInt(0);
            String tenalbum=cursor.getString(1);
            String tencasi=cursor.getString(2);
            byte[] hinhalbum=cursor.getBlob(3);
            item_AlbumArrayList.add(new album(idalbum,tenalbum,tencasi,hinhalbum));
            cursor.moveToNext();

        }

        int spaceInPixels = getResources().getDimensionPixelSize(R.dimen.space_between_items);
        adapter_album = new Adapter_Album(this, item_AlbumArrayList);
        recyclerView.addItemDecoration(new SpaceItemDecoration(spaceInPixels, this));
        recyclerView.setLayoutManager(new GridLayoutManager(AlbumActivity.this, 2));
        recyclerView.setAnimation(null);
        recyclerView.setAdapter(adapter_album);
    }
}