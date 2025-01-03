package com.example.app_nhac.Adapter;





import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app_nhac.Activity.Album_NhacActivity;
import com.example.app_nhac.R;
import com.example.app_nhac.model.album;

import java.util.ArrayList;

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.Adapteralbum> {
    private Context context;
    private ArrayList<album> item_songArrayList;

    public AdapterAlbum(Context context, ArrayList<album> item_songArrayList) {
        this.context = context;
        this.item_songArrayList = item_songArrayList;
    }

    @NonNull
    @Override
    public Adapteralbum onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_album,parent,false);

        return new Adapteralbum(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapteralbum holder, int position) {
        album item_song=item_songArrayList.get(position);
        holder.txttenbh.setText(item_song.getTenalbum());
        holder.txttentg.setText(item_song.getTencasialbum());
        Bitmap hinhalbum = BitmapFactory.decodeByteArray(item_song.getHinhalbum(),0,item_song.getHinhalbum().length);
        holder.imageView.setImageBitmap(hinhalbum);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idalbum = item_song.getIdalbum();
                String tenalbum = item_song.getTenalbum();
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
        return item_songArrayList.size();
    }

    public class Adapteralbum extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView txttenbh,txttentg;

        public Adapteralbum(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagealbum);
            txttenbh=itemView.findViewById(R.id.txttenbhalbum);
            txttentg=itemView.findViewById(R.id.txttentgalbum);
        }
    }
}
