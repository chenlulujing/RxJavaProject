package com.san.os.rcommendmovie.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import java.util.Collection;

/**
 * @author chenlulu@qiyi.com
 * @Description
 * @date 2019-05-12 19:41
 */
public class ToolBox {

    public static int getDisplayWith(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

}
