package com.example.app_nhac.Fragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.app_nhac.Activity.Login;
import com.example.app_nhac.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Caidat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Caidat extends Fragment {

    private LinearLayout linearDangxuat;
    private  LinearLayout lineartrogiup;
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__caidat, container, false);

        linearDangxuat = view.findViewById(R.id.lineardangxuat);
        lineartrogiup=view.findViewById(R.id.lineartrogiup);
        linearDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
                dialog.setTitle("Thông báo");
                dialog.setMessage("Bạn có chắc muốn thoát không ?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), Login.class);
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create().show();
            }
        });
        lineartrogiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
                dialog.setTitle("Tiện ích");
                dialog.setMessage("App music giúp bạn truy cập và thưởng thức bài hát yêu thích từ thư viện của bạn bất cứ khi nào bạn muốn.");
                dialog.create().show();
            }
        });

        return view;
    }
}