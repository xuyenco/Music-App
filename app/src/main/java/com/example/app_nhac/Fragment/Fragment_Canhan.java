package com.example.app_nhac.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app_nhac.Adapter.MusicListAdapter;
import com.example.app_nhac.Database.Database;
import com.example.app_nhac.R;
import com.example.app_nhac.model.AudioModel;
import com.example.app_nhac.model.baihat;

import java.io.File;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Canhan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Canhan extends Fragment implements MusicListAdapter.MusicListAdapterListener  {
    RecyclerView recyclerView;
    TextView noMusicTextView;
    ArrayList<AudioModel> songsList = new ArrayList<>();

    ArrayList<baihat> baihatArrayList = new ArrayList<>();
    SearchView Search;
    public String linkbaihat;
    MusicListAdapter musicListAdapter;



    public Fragment_Canhan() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment_Canhan newInstance() {
        Fragment_Canhan fragment = new Fragment_Canhan();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__tim_kiem, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        noMusicTextView = view.findViewById(R.id.no_songs_text);
        Search = view.findViewById(R.id.search);

        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        };
        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";

        Cursor cursor = getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        while(cursor.moveToNext()){
            AudioModel songData = new AudioModel(cursor.getString(1),cursor.getString(0),cursor.getString(2));
            if(new File(songData.getPath()).exists()){
                songsList.add(songData);
            }
        }

        if(songsList.size()==0){
            noMusicTextView.setVisibility(View.VISIBLE);
        }else{
            //recyclerview
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            musicListAdapter = new MusicListAdapter(songsList,getContext().getApplicationContext(),this);
            recyclerView.setAdapter(musicListAdapter);
        }

        Search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String search = newText;
                musicListAdapter.getFilter().filter(search);
//                Toast.makeText(getContext(), search, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onMusicSelected(AudioModel AudioModel) {

    }
}