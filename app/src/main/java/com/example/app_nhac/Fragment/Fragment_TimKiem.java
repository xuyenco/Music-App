package com.example.app_nhac.Fragment;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_nhac.Adapter.MusicListAdapter;
import com.example.app_nhac.Database.Database;
import com.example.app_nhac.R;
import com.example.app_nhac.model.AudioModel;
import com.example.app_nhac.model.baihat;

import java.io.File;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_TimKiem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_TimKiem extends Fragment implements MusicListAdapter.MusicListAdapterListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    RecyclerView recyclerView;
    TextView noMusicTextView;
    ArrayList<AudioModel> songsList = new ArrayList<>();

    ArrayList<baihat> baihatArrayList = new ArrayList<>();
    SearchView Search;
    public String linkbaihat;
    MusicListAdapter musicListAdapter;

    String DATABASE_NAME="My_music.db";
    SQLiteDatabase database;

    public Fragment_TimKiem() {
        // Required empty public constructor
    }


    public static Fragment_TimKiem newInstance() {
        Fragment_TimKiem fragment = new Fragment_TimKiem();
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

        database= Database.initDatabase(getActivity(),DATABASE_NAME);
        Cursor cursor=database.query("baihat",null,null,null,null,null,null);
        cursor.moveToFirst();
        baihatArrayList.clear();
        while (cursor.isAfterLast()==false){

            int idbaihat =cursor.getInt(0);
            int idalbum =cursor.getInt(1);
            int idtheloai=cursor.getInt(2);
            int idplaylist=cursor.getInt(3);
            String tenbaihat=cursor.getString(4);
            byte[] hinhbaihat=cursor.getBlob(5);

            String casi=cursor.getString(6);
            linkbaihat=cursor.getString(7);


            songsList.add(new AudioModel(linkbaihat,tenbaihat,"12321",hinhbaihat,casi));
            baihatArrayList.add(new baihat(idbaihat,idalbum,idtheloai,idplaylist,tenbaihat,casi,linkbaihat,hinhbaihat));
            cursor.moveToNext();
        }
//
//        String[] projection = {
//                MediaStore.Audio.Media.TITLE,
//                MediaStore.Audio.Media.DATA,
//                MediaStore.Audio.Media.DURATION
//        };
//        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";
//
//        Cursor cursor = getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
//        while(cursor.moveToNext()){
//            AudioModel songData = new AudioModel(cursor.getString(1),cursor.getString(0),cursor.getString(2));
//            if(new File(songData.getPath()).exists()){
//                songsList.add(songData);
//            }
//        }

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
