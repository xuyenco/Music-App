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
import com.example.app_nhac.Activity.NhacDangChayActivity;
import com.example.app_nhac.Instance.MyMediaPlayer;
import com.example.app_nhac.R;
import com.example.app_nhac.model.AudioModel;
import com.example.app_nhac.model.baihat;

import java.util.ArrayList;

public class Adapter_Album_Nhac extends RecyclerView.Adapter<Adapter_Album_Nhac.ViewHolder> {
    Context context;
    ArrayList<baihat> baiHatArrayList;
    ArrayList<AudioModel> songsList = new ArrayList<>();

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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to another acitivty

//                AudioModel temp = new AudioModel();
//                temp.setImage(baihat.getHinhbaihat());
//                temp.setPath(baihat.getLinkbaihat());
//                temp.setTitle(baihat.getTenbaihat());
//                songsList.add(temp);
                songsList.add(new AudioModel(baihat.getLinkbaihat(),baihat.getTenbaihat(),"12321",baihat.getHinhbaihat(),baihat.getCasi()));

                MyMediaPlayer.getInstance().reset();
                MyMediaPlayer.currentIndex = 0;
                Intent intent = new Intent(context, NhacDangChayActivity.class);
                intent.putExtra("LIST",songsList);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
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
