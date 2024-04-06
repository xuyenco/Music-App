package com.example.app_nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.app_nhac.Activity.Album_NhacActivity;
import com.example.app_nhac.Activity.TheLoai_NhacActivity;
import com.example.app_nhac.R;
import com.example.app_nhac.model.album;

import java.util.ArrayList;

public class Adapter_Album extends RecyclerView.Adapter<Adapter_Album.ViewHolder> {
    Context context;
    ArrayList<album> item_albumArrayList;

    public Adapter_Album(Context context, ArrayList<album> item_albumArrayList) {
        this.context = context;
        this.item_albumArrayList = item_albumArrayList;
    }
    @NonNull
    @Override
    public Adapter_Album.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.album_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Album.ViewHolder holder, int position) {
        album album = item_albumArrayList.get(position);
        Glide.with(context)
                .load(album.getHinhalbum())
                .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache hình ảnh để tăng hiệu suất
                .centerCrop() // Cắt hoặc giãn hình ảnh để phù hợp với ImageView
                .into(holder.imageView);
        holder.textView.setText(album.getTenalbum());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int idalbum = album.getIdalbum();
                String tenalbum = album.getTenalbum();
                System.out.println(idalbum);
                Intent intent = new Intent(context, Album_NhacActivity.class);
                intent.putExtra("idAlbum", idalbum);
                intent.putExtra("album", tenalbum);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item_albumArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_Album);
            imageView = itemView.findViewById(R.id.imageviewAlbum);
        }
    }
}
