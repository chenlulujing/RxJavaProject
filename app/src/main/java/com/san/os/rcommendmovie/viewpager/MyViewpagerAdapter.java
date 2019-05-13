package com.san.os.rcommendmovie.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenlulu@qiyi.com
 * @Description
 * @date 2019-05-12 20:20
 */
public class MyViewpagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();

    public MyViewpagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void setFragments(List<Fragment> fragments) {
         mFragments = fragments;
         notifyDataSetChanged();
    }
}
