package com.example.app_nhac.Adapter;





import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_nhac.Model.Album;

import com.example.app_nhac.R;

import java.util.ArrayList;

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.Adapteralbum> {
    private Context context;
    private ArrayList<Album> item_songArrayList;

    public AdapterAlbum(Context context, ArrayList<Album> item_songArrayList) {
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
        Album item_song=item_songArrayList.get(position);
        holder.txttenbh.setText(item_song.getTenbh());
        holder.txttentg.setText(item_song.getTentg());
        holder.imageView.setImageResource(item_song.getImagealbum());

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
