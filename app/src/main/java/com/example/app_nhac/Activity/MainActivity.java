package com.example.app_nhac.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
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


}