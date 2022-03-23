package com.example.retrofitgetkotlin.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.retrofitgetkotlin.Fragment.CallApi;
import com.example.retrofitgetkotlin.Fragment.PostApi;
import com.example.retrofitgetkotlin.Fragment.ViewPager;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CallApi();
            case 1:
                return new PostApi();
            case 2:
                return new ViewPager();
            default:
                return new CallApi();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
