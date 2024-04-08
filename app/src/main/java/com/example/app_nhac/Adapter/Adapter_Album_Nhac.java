package com.example.app_nhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_nhac.R;
import com.example.app_nhac.model.baihat;

import java.util.ArrayList;

public class Adapter_Album_Nhac extends RecyclerView.Adapter<Adapter_Album_Nhac.ViewHolder> {
    Context context;
    ArrayList<baihat> baiHatArrayList;

    public Adapter_Album_Nhac(Context context, ArrayList<baihat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }
    @NonNull
    @Override
    public Adapter_Album_Nhac.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.theloai_nhac_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Album_Nhac.ViewHolder holder, int position) {
        baihat baihat = baiHatArrayList.get(position);
        holder.tv_casi.setText(baihat.getCasi());
        holder.tv_ten.setText(baihat.getTenbaihat());
        Glide.with(context).load(baihat.getHinhbaihat()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_ten;
        TextView tv_casi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_tl_nhac);
            tv_casi = itemView.findViewById(R.id.tv_tl_nhac_casi);
            tv_ten = itemView.findViewById(R.id.tv_tl_nhac_ten);
        }
    }
}
