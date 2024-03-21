package com.example.app_nhac.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_nhac.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Canhan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Canhan extends Fragment {



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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__canhan, container, false);
    }
}