package com.san.os.rcommendmovie.viewpager;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.san.os.rcommendmovie.R;
import com.san.os.rcommendmovie.utils.ToolBox;

import java.util.List;

/**
 */

public class TabView extends HorizontalScrollView implements RadioGroup.OnCheckedChangeListener {

    private static final int DURATION = 600;
    private static final int PADDING_RIGHT = 50;
    private List<String> mData;
    private RadioGroup mRadioGroup;
    private int mIndex = -1;
    private int ITEM_WIDTH;
    private Context mContext;

    public TabView(Context context) {
        super(context);
        init(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        ITEM_WIDTH = (int) ((ToolBox.getDisplayWith((Activity) getContext()) - ToolBox.dip2px(getContext(),50)) / 5.7);
        setPadding(0, 0, ToolBox.dip2px(getContext(),PADDING_RIGHT), 0);
        setHorizontalScrollBarEnabled(false);
    }

    public void setData(List<String> data) {
        mData = data;
        //若栏目定宽总宽度小于屏幕宽度，则按屏宽等分栏目
        if (!ToolBox.isEmpty(mData)) {
            mRadioGroup = new RadioGroup(getContext());
            mRadioGroup.setOrientation(LinearLayout.HORIZONTAL);
            mRadioGroup.setGravity(Gravity.CENTER);
            mRadioGroup.setOnCheckedChangeListener(this);

            for (int i = 0, size = mData.size(); i < size; i++) {
                RadioButton tab = new RadioButton(getContext());
                tab.setGravity(Gravity.CENTER);
                tab.setText(mData.get(i));
                int textWidth = (int) tab.getPaint().measureText(mData.get(i));
                RadioGroup.LayoutParams layoutParams;
                if (i % 2 == 0) {
                    layoutParams = new RadioGroup.LayoutParams(textWidth + ToolBox.dip2px(getContext(),30), ViewGroup.LayoutParams.MATCH_PARENT);
                } else {
                    layoutParams = new RadioGroup.LayoutParams(textWidth + ToolBox.dip2px(getContext(),20), ViewGroup.LayoutParams.MATCH_PARENT);
                }
                tab.setButtonDrawable(null);
                tab.setLayoutParams(layoutParams);
                mRadioGroup.addView(tab);
            }
            removeAllViews();
            addView(mRadioGroup);
        }
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (ToolBox.isEmpty(mData)) {
            return;
        }
        try {
            for (int i = 0, size = group.getChildCount(); i < size; i++) {
                RadioButton rb = ((RadioButton) group.getChildAt(i));
                if (rb.getId() == checkedId) {
                    ((RadioButton) group.getChildAt(i)).getPaint().setFakeBoldText(true);
                    mIndex = i;
                } else {
                    ((RadioButton) group.getChildAt(i)).getPaint().setFakeBoldText(false);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mIndex == -1) {
            return;
        }
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(mIndex);
        }

        if (mIndex > 1) {
            post(new Runnable() {

                @Override
                public void run() {
                    ObjectAnimator animator = ObjectAnimator.ofInt(TabView.this, "scrollX", (ITEM_WIDTH * mIndex - (ToolBox.getDisplayWith((Activity) getContext()) - ITEM_WIDTH) / 2));
                    animator.setDuration(DURATION);
                    animator.start();
                }
            });

        } else {
            ObjectAnimator animator = ObjectAnimator.ofInt(TabView.this, "scrollX", 0);
            animator.setDuration(DURATION);
            animator.start();
        }
    }


    public void setTabSeleted(int index) {
        try {
            mIndex = index;
            if (!ToolBox.isEmpty(mData)) {
                for (int i = 0; i < mData.size(); i++) {
                    ((RadioButton) mRadioGroup.getChildAt(i)).getPaint().setFakeBoldText(i == mIndex);
                    ((RadioButton) mRadioGroup.getChildAt(i)).setTextColor(getContext().getResources().getColor(i == mIndex ? R.color.skin_color_tx_6 : R.color.skin_color_tx_1));

                }
            }
            RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(mIndex);
            if (radioButton != null) {
                mRadioGroup.check(radioButton.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OnCheckedChangeListener mOnCheckedChangeListener;


    public interface OnCheckedChangeListener {
        void onCheckedChanged(int index);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

}
