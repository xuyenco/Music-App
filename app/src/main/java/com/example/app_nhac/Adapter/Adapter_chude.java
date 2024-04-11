package com.example.app_nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app_nhac.Activity.Album_NhacActivity;
import com.example.app_nhac.Activity.TheLoai_NhacActivity;
import com.example.app_nhac.R;
import com.example.app_nhac.model.chude;
import com.example.app_nhac.model.theloai;

import java.util.ArrayList;

public class Adapter_chude extends RecyclerView.Adapter<Adapter_chude.adapter_chude> {
     private Context context;
     private ArrayList<chude> item_songArrayList;
     private ArrayList<theloai> theloaiArrayList;

    public Adapter_chude(Context context, ArrayList<chude> item_songArrayList,ArrayList<theloai> theloaiArrayList) {
        this.context = context;
        this.item_songArrayList = item_songArrayList;
        this.theloaiArrayList = theloaiArrayList;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chude picked = item_songArrayList.get(position);
                for (theloai theloai : theloaiArrayList) {
                    if (theloai.getIdchude() == picked.getIdchude()) {
                        int idtheloai = theloai.getIdtheloai();
                        String tenTheLoai = theloai.getTentheloai();
                        Intent intent = new Intent(context, TheLoai_NhacActivity.class);
                        intent.putExtra("idtheloai", idtheloai);
                        intent.putExtra("theloai", tenTheLoai);
                        context.startActivity(intent);
                    }
                }
            }
        });

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
