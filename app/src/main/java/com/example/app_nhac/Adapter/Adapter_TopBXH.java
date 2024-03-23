package com.example.app_nhac.Adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_nhac.Model.TopBXH;
import com.example.app_nhac.R;


import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class Adapter_TopBXH extends RecyclerView.Adapter<Adapter_TopBXH.AdapterChude_theloai> {
   private Context context;
   private ArrayList<TopBXH> item_songArrayList;

    public Adapter_TopBXH(Context context, ArrayList<TopBXH> item_songArrayList) {
        this.context = context;
        this.item_songArrayList = item_songArrayList;
    }

    @NonNull
    @Override
    public AdapterChude_theloai onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view=LayoutInflater.from(context).inflate(R.layout.adaptersong,parent,false);
         return new AdapterChude_theloai(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChude_theloai holder, int position) {
      TopBXH item_song=item_songArrayList.get(position);
     holder.imagebh.setImageResource(item_song.getImage());
     holder.txttentg.setText(item_song.getTentg());
     holder.txttenbh.setText(item_song.getTenbh());

    }



    @Override
    public int getItemCount() {
        return item_songArrayList.size();
    }

    public class AdapterChude_theloai extends RecyclerView.ViewHolder{
              private ImageView imagebh;
              private TextView txttenbh,txttentg;


        public AdapterChude_theloai(@NonNull View itemView) {
            super(itemView);
            imagebh=itemView.findViewById(R.id.imagesong);
            txttenbh=itemView.findViewById(R.id.txttenbh);
            txttentg=itemView.findViewById(R.id.txttentg);
        }
    }
}
