package com.example.app_nhac.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app_nhac.R;
import com.example.app_nhac.model.chude;

import java.util.ArrayList;

public class Adapter_chude extends RecyclerView.Adapter<Adapter_chude.adapter_chude> {
     private Context context;
     private ArrayList<chude> item_songArrayList;

    public Adapter_chude(Context context, ArrayList<chude> item_songArrayList) {
        this.context = context;
        this.item_songArrayList = item_songArrayList;
    }

    @NonNull
    @Override
    public adapter_chude onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_chude,parent,false);
        return new adapter_chude(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_chude holder, int position) {
        chude item_song=item_songArrayList.get(position);
        Bitmap hinhchude = BitmapFactory.decodeByteArray(item_song.getHinhchude(),0,item_song.getHinhchude().length);
        holder.imagecd.setImageBitmap(hinhchude);

    }

    @Override
    public int getItemCount() {
        return item_songArrayList.size();
    }

    public class adapter_chude extends RecyclerView.ViewHolder{
        ImageView imagecd;

        public adapter_chude(@NonNull View itemView) {

            super(itemView);
            imagecd=itemView.findViewById(R.id.imagecd);
        }
    }
}
