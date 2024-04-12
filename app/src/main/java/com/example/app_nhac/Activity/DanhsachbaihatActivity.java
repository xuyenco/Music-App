package com.example.app_nhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.app_nhac.Adapter.DSbaihatadapter;
import com.example.app_nhac.Database.Database;
import com.example.app_nhac.R;
import com.example.app_nhac.model.baihat;
import com.example.app_nhac.model.quangcao;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DanhsachbaihatActivity extends AppCompatActivity {
    quangcao item_song;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdsbh;
    ImageView imageViewds;
    FloatingActionButton floatingActionButton;
    String DATABASE_NAME="My_music.db";
    SQLiteDatabase database;
    ArrayList<baihat> baihatArrayList;
    DSbaihatadapter dSbaihatadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        DateIntent();
        anhxa();
        init();
        if (item_song !=null && !item_song.getTenbaihat().equals("")){
            setValueInView(item_song.getTenbaihat(),item_song.getHinhanh());
            GetDataQuangcao(item_song.getIdbahat());
        };
    }

    private void GetDataQuangcao(int idquangcao) {
        database = Database.initDatabase(this, DATABASE_NAME);
        baihatArrayList=new ArrayList<>();
        dSbaihatadapter=new DSbaihatadapter(DanhsachbaihatActivity.this,baihatArrayList);
        Cursor cursor = database.query("baihat", null, null, null, null, null, null);
        cursor.moveToFirst();
        baihatArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                int idbaihat =cursor.getInt(0);

                String tenbaihat = cursor.getString(4);
                byte[] hinhbaihat = cursor.getBlob(5);

                String casi = cursor.getString(6);
                String linkbaihat = cursor.getString(7);

                // Thay thế phương thức này bằng cách bạn lấy idquangcao
                if (idquangcao == idbaihat) {
                    baihatArrayList.add(new baihat(idbaihat, tenbaihat, casi, hinhbaihat,linkbaihat));
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        recyclerViewdsbh.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
        recyclerViewdsbh.setAdapter(dSbaihatadapter);
        recyclerViewdsbh.setHasFixedSize(true);
        dSbaihatadapter.notifyDataSetChanged();
    }



    private void setValueInView(String ten,byte[] hinh) {
        Toast.makeText(this, item_song.getTenbaihat(), Toast.LENGTH_SHORT).show();
        collapsingToolbarLayout.setTitle(ten);

        Bitmap bitmap= BitmapFactory.decodeByteArray(hinh,0,hinh.length);
        BitmapDrawable bitmapDrawable=new BitmapDrawable(getResources(),bitmap);
        collapsingToolbarLayout.setBackground(bitmapDrawable);
        Glide.with(this).load(hinh).into(imageViewds);
    }

    private void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//1 view khi ấn vào để trở về trang trước
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

    }

    private void DateIntent() {
        Intent intent=getIntent();
        if (intent!=null){
            if (intent.hasExtra("qc")){
                item_song = (quangcao) intent.getSerializableExtra("qc");

            }
        }
    }
    private void anhxa(){
        imageViewds=findViewById(R.id.imageviewds);
        coordinatorLayout=findViewById(R.id.coordinator);
        collapsingToolbarLayout=findViewById(R.id.collapsingToolbar);
        floatingActionButton=findViewById(R.id.floatingactionbutton);
        recyclerViewdsbh=findViewById(R.id.recyclerviewdsbh);
        toolbar=findViewById(R.id.toolbards);

    }
}