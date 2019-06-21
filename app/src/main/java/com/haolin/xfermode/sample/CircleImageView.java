package com.haolin.xfermode.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 作者：haoLin_Lee on 2019/06/21 15:24
 * 邮箱：Lhaolin0304@sina.com
 * class: 圆角矩形图片
 */
@SuppressLint("AppCompatCustomView")
public class CircleImageView extends ImageView {
    private Paint mPaint;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmap1 = getRoundBitMap(bitmap);
            mPaint.reset();
            canvas.drawBitmap(bitmap1, null,
                    new Rect(0, 0, getWidth(),getHeight()), mPaint);
        } else {
            super.onDraw(canvas);
        }

    }

    private Bitmap getRoundBitMap(Bitmap bitmap) {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        mPaint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        mPaint.setColor(0xff000000);
        canvas.drawRoundRect(new RectF(rect), 20, 20, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, mPaint);
        mPaint.setXfermode(null);
        return bitmap1;
    }
}
