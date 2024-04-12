package com.example.app_nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.app_nhac.Activity.DanhsachbaihatActivity;

import com.example.app_nhac.Activity.NhacDangChayActivity;
import com.example.app_nhac.Instance.MyMediaPlayer;
import com.example.app_nhac.R;
import com.example.app_nhac.model.AudioModel;
import com.example.app_nhac.model.baihat;
import com.example.app_nhac.model.quangcao;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adapterbanner extends PagerAdapter {
    Context context;
    ArrayList<quangcao> quangcaoArrayList;

    ArrayList<baihat> baihatArrayList;

    ArrayList<AudioModel> songsList = new ArrayList<>();

    public Adapterbanner(Context context, ArrayList<quangcao> item_songArrayList, ArrayList<baihat> baihatArrayList) {
        this.context = context;
        this.quangcaoArrayList = item_songArrayList;
        this.baihatArrayList = baihatArrayList;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.adapter_quangcao,null);
        ImageView imageqc=view.findViewById(R.id.imageqc);
        ImageView imageviewqc=view.findViewById(R.id.imageviewqc);
        TextView txttenqc=view.findViewById(R.id.txttenqc);
        TextView txtgtqc=view.findViewById(R.id.txtgtqc);
        byte[] imageData = quangcaoArrayList.get(position).getHinhanh();

        // Chuyển đổi dữ liệu blob thành một đối tượng Bitmap





        Glide.with(context).load(imageData).into(imageqc);
        Glide.with(context).load(imageData).into(imageviewqc);
//        if (baihatArrayList.get(position).getIdbaihat()==quangcaoArrayList.get(position).getIdbahat()) {
//            txttenqc.setText(baihatArrayList.get(position).getTenbaihat());
//        }
        txttenqc.setText(quangcaoArrayList.get(position).getTenbaihat());
        txtgtqc.setText(quangcaoArrayList.get(position).getNoidung());
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(context, DanhsachbaihatActivity.class);
//                intent.putExtra("qc", (Serializable) quangcaoArrayList.get(position));
//                context.startActivity(intent);


                for (baihat baihat :baihatArrayList){
                    if (baihat.getIdbaihat() == quangcaoArrayList.get(position).getIdbahat()){
                        songsList.add(new AudioModel(baihat.getLinkbaihat(),baihat.getTenbaihat(),"12321",baihat.getHinhbaihat(),baihat.getCasi()));

                        MyMediaPlayer.getInstance().reset();
                        MyMediaPlayer.currentIndex = 0;
                        Intent intent = new Intent(context, NhacDangChayActivity.class);
                        intent.putExtra("LIST",songsList);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }

            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}