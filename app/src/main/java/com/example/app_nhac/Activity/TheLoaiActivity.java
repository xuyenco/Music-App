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

import com.example.app_nhac.Adapter.Adapter_TheLoai;
import com.example.app_nhac.Database.Database;
import com.example.app_nhac.R;
import com.example.app_nhac.RecycleViewDecoration.SpaceItemDecoration;
import com.example.app_nhac.model.baihat;
import com.example.app_nhac.model.theloai;

import java.util.ArrayList;

public class TheLoaiActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;

    Adapter_TheLoai adapter_TheLoai;
    ArrayList<theloai> item_TLArrayList = new ArrayList<>();
    String DATABASE_NAME="My_music.db";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_the_loai);

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
        recyclerView = findViewById(R.id.recyclerviewTL);
        toolbar = findViewById(R.id.toolbarTL);
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thể loại");

        Cursor cursor=database.query("theloai",null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){

            int idtheloai=cursor.getInt(0);
            int idchude=cursor.getInt(1);
            String tentheloai=cursor.getString(2);
            byte[] hinhtl=cursor.getBlob(3);
            item_TLArrayList.add(new theloai(idtheloai,idchude,tentheloai,hinhtl));
            cursor.moveToNext();

        }

        cursor.close();

        int spaceInPixels = getResources().getDimensionPixelSize(R.dimen.space_between_items);
        adapter_TheLoai = new Adapter_TheLoai(this, item_TLArrayList);
        recyclerView.addItemDecoration(new SpaceItemDecoration(spaceInPixels, this));
        recyclerView.setLayoutManager(new GridLayoutManager(TheLoaiActivity.this, 2));
        recyclerView.setAnimation(null);
        recyclerView.setAdapter(adapter_TheLoai);
    }
}