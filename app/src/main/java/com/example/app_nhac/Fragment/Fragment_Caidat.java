package com.example.app_nhac.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_nhac.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Caidat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Caidat extends Fragment {


    public Fragment_Caidat() {
        // Required empty public constructor
    }

    public static Fragment_Caidat newInstance() {
        Fragment_Caidat fragment = new Fragment_Caidat();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__caidat, container, false);
    }
}