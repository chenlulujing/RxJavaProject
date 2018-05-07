package com.san.os.rcommendmovie.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author luluc@yiche.com
 * @Description
 * @date 2017-12-16 11:56
 */

public class MyListView extends FlowLayout {
    public MyListView(Context context) {
        super(context);
        init(context);
    }

    public MyListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        setPadding(100, 10, 10, 10);
//        for (int i = 0, size = 2; i < size; i++) {
//            TextView item = new TextView(context);
//            item.setText("items");
//            addView(item);
//        }

        TextView name1 = new TextView(context);
        name1.setText("name1");
        addView(name1);

        TextView value1 = new TextView(context);
        value1.setText("value1");
        addView(value1);

        TextView name2 = new TextView(context);
        name2.setText("name2");
        addView(name2);

        TextView value2 = new TextView(context);
        value2.setText("value2");
        addView(value2);


    }


}
