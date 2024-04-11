package com.example.app_nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_nhac.Activity.NhacDangChayActivity;
import com.example.app_nhac.Instance.MyMediaPlayer;
import com.example.app_nhac.model.AudioModel;
import com.example.app_nhac.R;

import java.util.ArrayList;
import java.util.List;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> implements Filterable {

    ArrayList<AudioModel> songsList;
    ArrayList<AudioModel> filteredList = new ArrayList<>();
    ArrayList<AudioModel> filteredList2 = new ArrayList<>();
    Context context;
    MusicListAdapterListener listener;

    public interface MusicListAdapterListener {
        void onMusicSelected(AudioModel AudioModel);
    }


    public MusicListAdapter(ArrayList<AudioModel> songsList, Context context, MusicListAdapterListener listener) {
        this.listener = listener;
        this.songsList = songsList;
        this.context = context;
        this.filteredList = songsList;
        this.filteredList2 = songsList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.theloai_nhac_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        AudioModel songData = songsList.get(position);
        holder.tv_ten.setText(songData.getTitle());
        holder.tv_casi.setText(songData.getSinger());
        Glide.with(context).load(songData.getImage()).into(holder.imageView);

        if(MyMediaPlayer.currentIndex==position){
            holder.tv_ten.setTextColor(Color.parseColor("#FF0000"));
        }else{
            holder.tv_ten.setTextColor(Color.parseColor("#000000"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to another acitivty

                MyMediaPlayer.getInstance().reset();
//                MyMediaPlayer.currentIndex = position;
                Intent intent = new Intent(context, NhacDangChayActivity.class);
                intent.putExtra("LIST",songsList);
                intent.putExtra("index",position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
               FilterResults results = new FilterResults();
                if(constraint==null || constraint.length()==0){
                    results.count = filteredList.size();
                    results.values = filteredList;
                }else{
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    List<AudioModel> filteredListTemp = new ArrayList<>();
                    for(AudioModel song : filteredList2){
                        if(song.getTitle().toLowerCase().contains(filterPattern)){
                            filteredListTemp.add(song);
                        }
                    }

                    results.count = filteredListTemp.size();
                    results.values = filteredListTemp;
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                songsList =(ArrayList<AudioModel>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

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
