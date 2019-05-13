package com.san.os.rcommendmovie.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.san.os.rcommendmovie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenlulu@qiyi.com
 * @Description
 * @date 2019-05-12 19:51
 */
public class ViewPgaerActivity extends FragmentActivity {


    private TabView mTabView;
    private ViewPager mViewPager;
    private MyViewpagerAdapter myViewpagerAdapter;
    private List<String> mData = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>() ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        initData();
        initView();
    }

    private void initData() {
        for(int i=0,size=2;i<size;i++){
            mData.add(""+i);
        }
    }

    private void initView() {
        mTabView = findViewById(R.id.tabview);
        mViewPager = findViewById(R.id.viewpager);
        myViewpagerAdapter = new MyViewpagerAdapter(getSupportFragmentManager(),generateFragments(mData));
        mViewPager.setAdapter(myViewpagerAdapter);
        mTabView.setData(mData);

        mTabView.setOnCheckedChangeListener(new TabView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(int index) {
                mViewPager.setCurrentItem(index);
            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  tag = mData.size()+"";
                mData.add(tag);
                Fragment fragment = ItemFragment.onNewInstace(tag);
                mFragments.add(fragment);
                myViewpagerAdapter.setFragments(mFragments);
                mTabView.setData(mData);
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(mData.size()-1);
                mFragments.remove(mFragments.size()-1);
                myViewpagerAdapter.setFragments(mFragments);
                mTabView.setData(mData);

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabView.setTabSeleted(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private List<Fragment> generateFragments(List<String> list){
        for(String item:list){
            mFragments.add(ItemFragment.onNewInstace(item));
        }

        return  mFragments;
    }
}
