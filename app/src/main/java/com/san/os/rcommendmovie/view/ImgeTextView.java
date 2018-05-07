package com.san.os.rcommendmovie.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.san.os.rcommendmovie.R;

/**
 * @author luluc@yiche.com
 * @Description
 * @date 2017-12-20 11:01
 */

public class ImgeTextView extends TextView {


    private int drawableL;
    private int drawableT;
    private int drawableR;
    private int drawableB;

    public ImgeTextView(Context context) {
        super(context);
    }

    public ImgeTextView(Context context, int l, int t, int r, int b) {
        super(context);
        drawableL = l;
        drawableT = t;
        drawableR = r;
        drawableB = b;
    }

    public ImgeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImgeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (drawableL > 0) {
//            Drawable drawableL = getContext().getResources().getDrawable(R.mipmap.ic_launcher);
//            BitmapDrawable drawable = (BitmapDrawable) drawableL;
//

            Bitmap bitmapL = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            canvas.drawBitmap(bitmapL, 0, 0, getPaint());
        }
        if (drawableT > 0) {

        }
        if (drawableR > 0) {

        }
        if (drawableB > 0) {

        }
    }
}
