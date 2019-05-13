package com.san.os.rcommendmovie.viewpager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.san.os.rcommendmovie.R;

/**
 * @author chenlulu@qiyi.com
 * @Description
 * @date 2019-05-12 20:25
 */
public class ItemFragment  extends Fragment {

    public static String PARAM = "param_tag" ;


    public static ItemFragment onNewInstace(String param){
        ItemFragment fragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM,param);
        fragment.setArguments(bundle);
        return  fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_item,null);
        ((TextView) rootview.findViewById(R.id.tag)).setText(getArguments().getString(PARAM));
        return rootview;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
