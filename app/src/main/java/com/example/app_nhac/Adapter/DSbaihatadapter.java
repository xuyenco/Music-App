package com.example.app_nhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_nhac.R;
import com.example.app_nhac.model.baihat;


import java.util.ArrayList;

public class DSbaihatadapter extends RecyclerView.Adapter<DSbaihatadapter.dsbhadapter> {
    Context context;
    ArrayList<baihat> baihatArrayList;

    public DSbaihatadapter(Context context, ArrayList<baihat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @NonNull
    @Override
    public dsbhadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.dsbaihatadapter,parent,false);
        return new dsbhadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dsbhadapter holder, int position) {
        baihat item_bh=baihatArrayList.get(position);
        holder.txttentg.setText(item_bh.getCasi());
        holder.txttenbh.setText(item_bh.getTenbaihat());
        holder.txtindex.setText(position+1+" ");
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class dsbhadapter extends RecyclerView.ViewHolder{
        TextView txtindex,txttentg,txttenbh;

        public dsbhadapter(@NonNull View itemView) {
            super(itemView);
            txtindex=itemView.findViewById(R.id.txtindex);
            txttenbh=itemView.findViewById(R.id.tenbh);
            txttentg=itemView.findViewById(R.id.txttencs);
        }

    }
}