package com.example.app_nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.app_nhac.Activity.DanhsachbaihatActivity;
import com.example.app_nhac.Model.Quangcao;
import com.example.app_nhac.Model.TopBXH;
import com.example.app_nhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapterbanner extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> item_songArrayList;

    public Adapterbanner(Context context, ArrayList<Quangcao> item_songArrayList) {
        this.context = context;
        this.item_songArrayList = item_songArrayList;
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
        Picasso.with(context).load(item_songArrayList.get(position).getImagebh()).into(imageqc);
        Picasso.with(context).load(item_songArrayList.get(position).getImageqc()).into(imageviewqc);
        txttenqc.setText(item_songArrayList.get(position).getTenbh());
        txtgtqc.setText(item_songArrayList.get(position).getGioithieu());
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("qc",item_songArrayList.get(position));
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
