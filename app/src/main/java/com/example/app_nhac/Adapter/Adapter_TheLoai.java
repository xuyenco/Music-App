package com.example.app_nhac.Adapter;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.app_nhac.Activity.TheLoai_NhacActivity;
import com.example.app_nhac.R;
import com.example.app_nhac.model.baihat;
import com.example.app_nhac.model.theloai;

import java.util.ArrayList;
import java.util.List;

public class Adapter_TheLoai extends RecyclerView.Adapter<Adapter_TheLoai.ViewHolder> {
    Context context;
    ArrayList<theloai> item_TLArrayList;

    public Adapter_TheLoai(Context context, ArrayList<theloai> item_TLArrayList) {
        this.context = context;
        this.item_TLArrayList = item_TLArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.theload_item,parent,false);
//        Context mContext = parent.getContext();
//        Khởi tạo LayoutInflater và inflate layout cho ViewHolder
//        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        theloai chude = item_TLArrayList.get(position);
        Glide.with(context)
                .load(chude.getHinhtheloai())
                .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache hình ảnh để tăng hiệu suất
                .centerCrop() // Cắt hoặc giãn hình ảnh để phù hợp với ImageView
                .into(holder.imageView);
        holder.textView.setText(chude.getTentheloai());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int idtheloai = chude.getIdtheloai();
                String tenTheLoai = chude.getTentheloai();
                Intent intent = new Intent(context, TheLoai_NhacActivity.class);
                intent.putExtra("idtheloai", idtheloai);
                intent.putExtra("theloai", tenTheLoai);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item_TLArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_TL);
            imageView = itemView.findViewById(R.id.imageviewTL);

        } //RecyclerView.ViewHolder
    }

}
