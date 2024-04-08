package com.example.app_nhac.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;


import com.example.app_nhac.Adapter.ViewPagerAdapter;
import com.example.app_nhac.Fragment.Fragment_Caidat;
import com.example.app_nhac.Fragment.Fragment_Canhan;
import com.example.app_nhac.Fragment.Fragment_TimKiem;
import com.example.app_nhac.Fragment.Fragment_Trangchu;
import com.example.app_nhac.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter mAdapter;
private int[] mTabTitle=new int[]{R.string.tab_trangchu_title,R.string.tab_timkiem_title,R.string.tab_canhan_title,R.string.tab_caidat_title};
    private int[] mTabIcon=new int[]{R.drawable.home,R.drawable.loupe,R.drawable.user,R.drawable.cogwheel};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.MyTableLayout);
        viewPager=findViewById(R.id.myViewPager);
        if(checkPermission() == false){
            requestPermission();
            return;
        }
        init();
    }
    public void init(){

        mAdapter = new ViewPagerAdapter(this);
        mAdapter.addFragment(new Fragment_Trangchu());
        mAdapter.addFragment(new Fragment_TimKiem());
        mAdapter.addFragment(new Fragment_Canhan());
        mAdapter.addFragment(new Fragment_Caidat());


        viewPager.setAdapter(mAdapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                tab.setIcon(MainActivity.this.getResources().getDrawable(mTabIcon[position]));
                tab.setText(MainActivity.this.getResources().getString(mTabTitle[position]));
            }
        }).attach();

    }
    boolean checkPermission(){
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            int result = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_MEDIA_AUDIO);
            if(result == PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                return false;
            }
        }else{
            int result = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
            if(result == PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                return false;
            }
        }
    }

    void requestPermission(){
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_MEDIA_AUDIO)){
                Toast.makeText(MainActivity.this,"READ PERMISSION IS REQUIRED,PLEASE ALLOW FROM SETTTINGS",Toast.LENGTH_SHORT).show();
            }else
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_MEDIA_AUDIO},123);
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(MainActivity.this,"READ PERMISSION IS REQUIRED,PLEASE ALLOW FROM SETTTINGS",Toast.LENGTH_SHORT).show();
            }else
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
        }
    }


}