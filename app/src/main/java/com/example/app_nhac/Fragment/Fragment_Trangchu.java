package com.example.app_nhac.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.app_nhac.Adapter.AdapterAlbum;
import com.example.app_nhac.Adapter.AdapterChude_Theloai;
import com.example.app_nhac.Model.item_song;
import com.example.app_nhac.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Trangchu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Trangchu extends Fragment {
     private  Toolbar toolbar;
    private ViewFlipper viewFlipper;
    private RecyclerView recyclerViewchude;
    private RecyclerView recyclerViewalbum;
    private RecyclerView recyclerViewtopbxh;

    private NavigationView navigationView;
    private  ListView listViewtrangchu;
    private ArrayList<item_song> item_songArrayList;
    private AdapterChude_Theloai adapterChude_theloai;
    private AdapterAlbum adapterAlbum;

    private int[] imageIds = {R.drawable.anh1, R.drawable.anh2, R.drawable.anh3};
    private int currentImageIndex = 0;
    private Handler handler;
    private Runnable runnable;

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
        View view=inflater.inflate(R.layout.fragment__trangchu, container, false);
        toolbar=view.findViewById(R.id.toolbartrangchu);
        viewFlipper=view.findViewById(R.id.viewflipper);
        recyclerViewchude=view.findViewById(R.id.recyclerviewchude);
        recyclerViewalbum=view.findViewById(R.id.recyclerviewalbum);
        recyclerViewtopbxh=view.findViewById(R.id.recyclerviewtopbxh);
        item_song item_song1=new item_song(1,"Sau lời từ khước","Phan Mạnh Quỳnh",R.drawable.sauloitukhuoc);
        item_song item_song2=new item_song(2,"Nâng chén tiêu sầu","Bích Phương",R.drawable.nangchentieusau);
        item_song item_song3=new item_song(3,"Chúng ta của tương lai","Sơn Tùng",R.drawable.chungtacuatuonglai);
        item_song item_song4=new item_song(4,"Anh nhớ ra","Vũ",R.drawable.anhnhora);
        item_song item_song5=new item_song(5,"Ngày em đẹp nhất","TAMA",R.drawable.ngayemdepnhta);
        item_song item_song6=new item_song(6,"Người ta có thương mình","Trúc Nhân",R.drawable.nguoitacothuongminh);
        item_songArrayList=new ArrayList<>();
        item_songArrayList.add(item_song1);
        item_songArrayList.add(item_song2);
        item_songArrayList.add(item_song3);
        item_songArrayList.add(item_song4);
        item_songArrayList.add(item_song5);
        item_songArrayList.add(item_song6);
        recyclerViewtopbxh.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterChude_theloai=new AdapterChude_Theloai(getContext(),item_songArrayList);
        recyclerViewtopbxh.setAdapter(adapterChude_theloai);
        recyclerViewtopbxh.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);


        recyclerViewalbum.setLayoutManager(linearLayoutManager);
        recyclerViewalbum.setHasFixedSize(true);
        adapterAlbum=new AdapterAlbum(getContext(),item_songArrayList);
        recyclerViewalbum.setAdapter(adapterAlbum);








        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();

        // Inflate the layout for this fragment

        return view;

    }

}