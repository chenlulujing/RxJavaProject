package com.san.os.rcommendmovie.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author luluc@yiche.com
 * @Description
 * @date 2017-12-16 11:51
 */

public class FlowLayout extends LinearLayout {
    public FlowLayout(Context context) {
        super(context);
        init(context);
    }

    public FlowLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FlowLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(HORIZONTAL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //1、让系统自己计算宽高
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



        //2、根据自己的需求计算合适的宽高
        //TODO




        //3、setMeasuredDimension()保存计算得来的宽高
//        setMeasuredDimension();

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i("lulu_flow", "changed ==" + changed+";l=="+l+";t="+t+";r="+r+";b="+b);

        Log.i("lulu_flow",l+","+t+","+r+","+b);
        super.onLayout(changed, l, t,r,b);

//
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            if (i == 0) {
//                View childView1 = getChildAt(i);
//                childView1.layout(getPaddingLeft(), 0, childView1.getMeasuredWidth()+getPaddingLeft(), childView1.getMeasuredHeight());
//            }else
//            if(i==1){
//                getChildAt(1).layout(getChildAt(0).getMeasuredWidth()+getPaddingLeft(), 0,  getChildAt(0).getMeasuredWidth()+ getChildAt(1).getMeasuredWidth()+getPaddingLeft(), getChildAt(1).getMeasuredHeight());
//            }else if(i==2){
//                getChildAt(2).layout(100, 300, 700, 700);
//            }else if(i==3){
//                getChildAt(3).layout(100, 300, 700, 700);
//            }
//
//        }
    }
}
