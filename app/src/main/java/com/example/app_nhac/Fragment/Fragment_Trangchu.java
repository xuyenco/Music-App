package com.example.app_nhac.Fragment;




import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app_nhac.Activity.AlbumActivity;
import com.example.app_nhac.Activity.TheLoaiActivity;
import com.example.app_nhac.Adapter.AdapterAlbum;
import com.example.app_nhac.Adapter.Adapter_TopBXH;
import com.example.app_nhac.Adapter.Adapter_chude;
import com.example.app_nhac.Adapter.Adapterbanner;
import com.example.app_nhac.Database.Database;

import com.example.app_nhac.R;
import com.example.app_nhac.model.album;
import com.example.app_nhac.model.baihat;
import com.example.app_nhac.model.chude;
import com.example.app_nhac.model.quangcao;
import com.example.app_nhac.model.theloai;


import java.util.ArrayList;
import java.util.Timer;

import me.relex.circleindicator.CircleIndicator;


public class Fragment_Trangchu extends Fragment {
    private Toolbar toolbar;
    private ViewPager ViewPager;
    private TextView txtXemThemTL, txtXemThemAlbum;
    private RecyclerView recyclerViewchude;
    private RecyclerView recyclerViewalbum;
    private RecyclerView recyclerViewbaihat;

    private CircleIndicator circleIndicator;

    private ArrayList<quangcao> quangcaoArrayList;
    private ArrayList<chude> chudeArrayList;
    private ArrayList<album>  albumArrayList;
    private ArrayList<baihat> baihatArrayList;
    private ArrayList<theloai> theloaiArrayList;
    private Adapter_TopBXH adapter_baihat;
    private Adapter_chude adapter_chude;
    private AdapterAlbum adapterAlbum;
    private Adapterbanner adapter_qc;
    private Timer timer;

    private Handler handler;
    private Runnable runnable;

    private int currentImageIndex ;

     String DATABASE_NAME="My_music.db";
   SQLiteDatabase database;
   public String linkbaihat;

    public Fragment_Trangchu() {
        // Required empty public constructor
    }


    public static Fragment_Trangchu newInstance() {
        Fragment_Trangchu fragment = new Fragment_Trangchu();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {


        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__trangchu, container, false);
        toolbar = view.findViewById(R.id.toolbartrangchu);
        ViewPager = view.findViewById(R.id.ViewPager);
          circleIndicator=view.findViewById(R.id.circle_center);
        recyclerViewchude = view.findViewById(R.id.recyclerviewchude);
        recyclerViewalbum = view.findViewById(R.id.recyclerviewalbum);
        recyclerViewbaihat = view.findViewById(R.id.recyclerviewtopbxh);
        txtXemThemTL = view.findViewById(R.id.tvXemThemTL);
        txtXemThemAlbum = view.findViewById(R.id.tvXemThemAlbum);
       database= Database.initDatabase(getActivity(),DATABASE_NAME);
       baihatArrayList=new ArrayList<>();
        adapter_baihat = new Adapter_TopBXH(getContext(), baihatArrayList);

        txtXemThemTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TheLoaiActivity.class);
                startActivity(intent);
            }
        });

        txtXemThemAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlbumActivity.class);
                startActivity(intent);
            }
        });

        Cursor cursor=database.query("baihat",null,null,null,null,null,null);
        cursor.moveToFirst();
         baihatArrayList.clear();
        while (cursor.isAfterLast()==false){

            int idbaihat =cursor.getInt(0);
            int idalbum =cursor.getInt(1);
            int idtheloai=cursor.getInt(2);
            int idplaylist=cursor.getInt(3);
            String tenbaihat=cursor.getString(4);
            byte[] hinhbaihat=cursor.getBlob(5);

            String casi=cursor.getString(6);
             linkbaihat=cursor.getString(7);

            baihatArrayList.add(new baihat(idbaihat,idalbum,idtheloai,idplaylist,tenbaihat,casi,linkbaihat,hinhbaihat));
            cursor.moveToNext();
        }

        cursor.close();
        recyclerViewbaihat.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewbaihat.setAdapter(adapter_baihat);
        recyclerViewbaihat.setHasFixedSize(true);
        adapter_baihat.notifyDataSetChanged();

        chudeArrayList=new ArrayList<>();

        adapter_chude = new Adapter_chude(getContext(), chudeArrayList);
        Cursor cursor2=database.query("chude",null,null,null,null,null,null);
        cursor2.moveToFirst();
        chudeArrayList.clear();
        while (cursor2.isAfterLast()==false){

            int idchude =cursor2.getInt(0);
            String tenchude =cursor2.getString(1);
            byte[]  hinhchude=cursor2.getBlob(2);


            chudeArrayList.add(new chude(idchude,tenchude,hinhchude));
            cursor2.moveToNext();
        }

        cursor2.close();


        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewchude.setLayoutManager(linearLayout);

        recyclerViewchude.setAdapter(adapter_chude);
        adapter_chude.notifyDataSetChanged();

        albumArrayList=new ArrayList<>();

        adapterAlbum = new AdapterAlbum(getContext(), albumArrayList);
        Cursor cursor3=database.query("album",null,null,null,null,null,null);
        cursor3.moveToFirst();
        albumArrayList.clear();
        while (cursor3.isAfterLast()==false){

            int idalbum =cursor3.getInt(0);
            String tenalbum =cursor3.getString(1);
            String tencasialbum=cursor3.getString(2);
            byte[]  hinhalbum=cursor3.getBlob(3);


            albumArrayList.add(new album(idalbum,tenalbum,tencasialbum,hinhalbum));
            cursor3.moveToNext();
        }

        cursor3.close();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewalbum.setLayoutManager(linearLayoutManager);
        recyclerViewalbum.setHasFixedSize(true);

        recyclerViewalbum.setAdapter(adapterAlbum);
        adapterAlbum.notifyDataSetChanged();

        quangcaoArrayList=new ArrayList<>();

        adapter_qc = new Adapterbanner(getContext(), quangcaoArrayList);
        Cursor cursor4=database.query("quangcao",null,null,null,null,null,null);
        cursor4.moveToFirst();
        quangcaoArrayList.clear();
        while (cursor4.isAfterLast()==false){

            int idqc =cursor4.getInt(0);
            byte[] hinhqc=cursor4.getBlob(1);
            String noidung =cursor4.getString(2);
            int idbaihat=cursor4.getInt(3);

            String tenbaihat="";
            for (baihat baihat: baihatArrayList){
                if (baihat.getIdbaihat()==idbaihat){
                    tenbaihat=baihat.getTenbaihat();
                    break;
                }
            }


            quangcaoArrayList.add(new quangcao(idqc,hinhqc,noidung,idbaihat,tenbaihat));
            cursor4.moveToNext();

        }

        cursor4.close();

        ViewPager.setAdapter(adapter_qc);
        adapter_qc.notifyDataSetChanged();
        circleIndicator.setViewPager(ViewPager);

      handler=new Handler();
      runnable =new Runnable() {
          @Override
          public void run() {
              currentImageIndex=ViewPager.getCurrentItem();
              currentImageIndex++;
              if (currentImageIndex>=ViewPager.getAdapter().getCount()){
                  currentImageIndex=0;
              }
              ViewPager.setCurrentItem(currentImageIndex,true);
              handler.postDelayed(runnable,3000);
          }
      };
      handler.postDelayed(runnable,3000);





        return view;

    }

}