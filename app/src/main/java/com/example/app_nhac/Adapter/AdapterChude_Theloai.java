package com.example.app_nhac.Adapter;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_nhac.Model.item_song;
import com.example.app_nhac.R;

import java.util.ArrayList;

public class AdapterChude_Theloai extends RecyclerView.Adapter<AdapterChude_Theloai.AdapterChude_theloai> {
   private Context context;
   private ArrayList<item_song> item_songArrayList;

    public AdapterChude_Theloai(Context context, ArrayList<item_song> item_songArrayList) {
        this.context = context;
        this.item_songArrayList = item_songArrayList;
    }

    @NonNull
    @Override
    public AdapterChude_theloai onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adaptersong,parent,false);

        return new AdapterChude_theloai(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChude_theloai holder, int position) {
      item_song item_song=item_songArrayList.get(position);
      holder.txttenbh.setText(item_song.getTentg());
      holder.txttentg.setText(item_song.getTentg());
      holder.imageView.setImageResource(item_song.getImage());

    }



    @Override
    public int getItemCount() {
        return item_songArrayList.size();
    }

    public class AdapterChude_theloai extends RecyclerView.ViewHolder{
           private ImageView imageView;
           private TextView txttenbh,txttentg;

        public AdapterChude_theloai(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagesong);
            txttenbh=itemView.findViewById(R.id.txttenbh);
            txttentg=itemView.findViewById(R.id.txttentg);
        }
    }
}
