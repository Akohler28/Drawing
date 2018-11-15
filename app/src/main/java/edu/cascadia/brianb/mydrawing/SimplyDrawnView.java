package edu.cascadia.brianb.mydrawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Edited by Brian Bansenauer on 10/18/15.
 */
public class SimplyDrawnView extends View {

    private Paint mPaint;
    private Path mPath;
    private float mWidth, mHeight;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        mPath = new Path();
     }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE); //draw background

        //Draw line
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(16.0f);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        //TODOne: Finish drawing red line
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        canvas.drawLine(mWidth, 5, 100, mHeight, mPaint);

        //TODOne: Draw green lines
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(mWidth, 50, 200, mHeight, mPaint);

        //TODOne: Draw Text
        mPaint.setStrokeWidth(50);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("Hello there!", 20, 20, mPaint);

        //TODOne: Draw Text on a Path
        Path path = new Path();
        mPaint.setColor(Color.BLUE);
        path.addCircle(40, 90, 100, Path.Direction.CW);
        canvas.drawTextOnPath("This one is on a path!", path, 0, 0, mPaint);

        //TODOne: Draw filled, opaque, and open ovals
        canvas.drawOval(mWidth, 0, mWidth - 50, 50, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawOval(100, 200, 200, 400, mPaint);
        mPaint.setAlpha(20);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawOval(400, 400, 500, 600, mPaint);


        //TODOne: Draw bee bitmap
        //     HINT: since b is a Drawable, you can use its .draw method, but .setBounds on it first
        Drawable b = getResources().getDrawable(R.drawable.bee,null);
        b.setBounds(10, 600,  100, 750);
        b.draw(canvas);

        //TODOne: Add another image to the project (copy and paste to Android Studio res/drawable folder)
        //     and draw it on the screen
        Drawable d = getResources().getDrawable(R.drawable.duck);
        d.setBounds(10, 775, 100, 900);
        d.draw(canvas);

    }
}
