package com.example.app_nhac.Fragment;




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

import com.example.app_nhac.Adapter.AdapterAlbum;
import com.example.app_nhac.Adapter.Adapter_TopBXH;
import com.example.app_nhac.Adapter.Adapter_chude;
import com.example.app_nhac.Adapter.Adapterbanner;
import com.example.app_nhac.Model.Album;
import com.example.app_nhac.Model.Chude;
import com.example.app_nhac.Model.Quangcao;
import com.example.app_nhac.Model.TopBXH;
import com.example.app_nhac.R;


import java.util.ArrayList;
import java.util.Timer;

import me.relex.circleindicator.CircleIndicator;


public class Fragment_Trangchu extends Fragment {
    private Toolbar toolbar;
    private ViewPager ViewPager;
    private RecyclerView recyclerViewchude;
    private RecyclerView recyclerViewalbum;
    private RecyclerView recyclerViewtopbxh;

    private CircleIndicator circleIndicator;

    private ArrayList<Quangcao> quangcaoArrayList;
    private ArrayList<Chude> chudeArrayList;
    private ArrayList<Album>  albumArrayList;
    private ArrayList<TopBXH> topBXHArrayList;
    private Adapter_TopBXH adapter_topBXH;
    private Adapter_chude adapter_chude;
    private AdapterAlbum adapterAlbum;
    private Adapterbanner adapter_qc;
    private Timer timer;

    private Handler handler;
    private Runnable runnable;

    private int currentImageIndex ;


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
        recyclerViewtopbxh = view.findViewById(R.id.recyclerviewtopbxh);


        TopBXH item_song1 = new TopBXH(1, "Sau lời từ khước", "Phan Mạnh Quỳnh", R.drawable.sauloitukhuoc );
        TopBXH item_song2 = new TopBXH(2, "Nâng chén tiêu sầu", "Bích Phương", R.drawable.nangchentieusau  );
        TopBXH item_song3 = new TopBXH(3, "Chúng ta của tương lai", "Sơn Tùng", R.drawable.chungtacuatuonglai );
        TopBXH item_song4 = new TopBXH(4, "Anh nhớ ra", "Vũ", R.drawable.anhnhora);
        TopBXH item_song5 = new TopBXH(5, "Ngày em đẹp nhất", "TAMA", R.drawable.ngayemdepnhta);
        TopBXH item_song6 = new TopBXH(6, "Người ta có thương mình", "Trúc Nhân", R.drawable.nguoitacothuongminh);
        Quangcao quangcao1=new Quangcao(R.drawable.pmq,R.drawable.sauloitukhuoc,"Sau lời từ khước","Bài hát được sáng tác cho nhạc phim Mai và thành công");
        Quangcao quangcao2=new Quangcao(R.drawable.bp,R.drawable.nangchentieusau,"Nâng chén tiêu sầu","Bài hát đã tạo ra 1 kỉ lục lượt view");
        Quangcao quangcao3=new Quangcao(R.drawable.st,R.drawable.chungtacuatuonglai,"Chúng ta của tương lai","Sơn Tùng là ca sĩ top đầu Việt nam");
         Chude Chude1=new Chude(R.drawable.chude);
        Chude Chude2=new Chude(R.drawable.chude2);
        Chude Chude3=new Chude(R.drawable.chude3);
        Album album1=new Album("Sau lời từ khước", "Phan Mạnh Quỳnh", R.drawable.sauloitukhuoc );
        Album album2=new Album("Nâng chén tiêu sầu", "Bích Phương", R.drawable.nangchentieusau);
        Album album3=new Album("Chúng ta của tương lai", "Sơn Tùng", R.drawable.chungtacuatuonglai );
        Album album4=new Album("Anh nhớ ra", "Vũ", R.drawable.anhnhora );
        Album album5=new Album("Ngày em đẹp nhất", "TAMA", R.drawable.ngayemdepnhta );
        Album album6=new Album("Người ta có thương mình", "Trúc Nhân", R.drawable.nguoitacothuongminh );

        topBXHArrayList = new ArrayList<>();
        topBXHArrayList.add(item_song1);
        topBXHArrayList.add(item_song2);
        topBXHArrayList.add(item_song3);
        topBXHArrayList.add(item_song4);
        topBXHArrayList.add(item_song5);
        topBXHArrayList.add(item_song6);

        chudeArrayList = new ArrayList<>();
        chudeArrayList.add(Chude1);
        chudeArrayList.add(Chude2);
        chudeArrayList.add(Chude3);
        quangcaoArrayList=new ArrayList<>();

        quangcaoArrayList.add(quangcao1);
        quangcaoArrayList.add(quangcao2);
        quangcaoArrayList.add(quangcao3);
        albumArrayList=new ArrayList<>();
        albumArrayList.add(album1);
        albumArrayList.add(album2);
        albumArrayList.add(album3);
        albumArrayList.add(album4);
        albumArrayList.add(album5);
        albumArrayList.add(album6);


        recyclerViewtopbxh.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter_topBXH = new Adapter_TopBXH(getContext(), topBXHArrayList);
        recyclerViewtopbxh.setAdapter(adapter_topBXH);
        recyclerViewtopbxh.setHasFixedSize(true);



        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewchude.setLayoutManager(linearLayout);
        adapter_chude=new Adapter_chude(getActivity(),chudeArrayList);
        recyclerViewchude.setAdapter(adapter_chude);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewalbum.setLayoutManager(linearLayoutManager);
        recyclerViewalbum.setHasFixedSize(true);
        adapterAlbum = new AdapterAlbum(getContext(), albumArrayList);
        recyclerViewalbum.setAdapter(adapterAlbum);


        adapter_qc = new Adapterbanner(getActivity(), quangcaoArrayList);
        ViewPager.setAdapter(adapter_qc);
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