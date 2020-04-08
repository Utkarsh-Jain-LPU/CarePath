package com.utkarsh.carepath;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        list = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
