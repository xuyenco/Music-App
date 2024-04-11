package com.example.app_nhac.Adapter;



import static android.graphics.BitmapFactory.decodeByteArray;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app_nhac.Activity.NhacDangChayActivity;
import com.example.app_nhac.Fragment.Fragment_Trangchu;
import com.example.app_nhac.Instance.MyMediaPlayer;
import com.example.app_nhac.R;
import com.example.app_nhac.model.AudioModel;
import com.example.app_nhac.model.baihat;


import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class Adapter_TopBXH extends RecyclerView.Adapter<Adapter_TopBXH.AdapterChude_theloai> {
   private Context context;
   private ArrayList<baihat> item_songArrayList;

    ArrayList<AudioModel> songsList = new ArrayList<>();

    public Adapter_TopBXH(Context context, ArrayList<baihat> item_songArrayList) {
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
      baihat item_song=item_songArrayList.get(position);
      Bitmap hinhbaihat = BitmapFactory.decodeByteArray(item_song.getHinhbaihat(),0,item_song.getHinhbaihat().length);
      holder.imagebh.setImageBitmap(hinhbaihat);
     holder.txttentg.setText(item_song.getCasi());
     holder.txttenbh.setText(item_song.getTenbaihat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to another acitivty

                songsList.add(new AudioModel(item_song.getLinkbaihat(),item_song.getTenbaihat(),"12321",item_song.getHinhbaihat(),item_song.getCasi()));

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
        return item_songArrayList.size();
    }

    public class AdapterChude_theloai extends RecyclerView.ViewHolder{
              private ImageView imagebh;
              private TextView txttenbh,txttentg;
             // private LinearLayout linearadaptersong;


        public AdapterChude_theloai(@NonNull View itemView) {
            super(itemView);
            imagebh=itemView.findViewById(R.id.imagesong);
            txttenbh=itemView.findViewById(R.id.txttenbh);
            txttentg=itemView.findViewById(R.id.txttentg);
          //  linearadaptersong=itemView.findViewById(R.id.linearadaptersong);
        }
    }
}
