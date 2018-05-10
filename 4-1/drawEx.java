package com.example.yea.lab4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class drawEx extends View {
    private Paint mPaint;
    private Path mPath;
    private float left,right;
    public void init(){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(15);

        mPath = new Path();
    }
    public drawEx(Context c){
        super(c);
        init();
    }
    public drawEx(Context c,AttributeSet a){
        super(c,a);
        init();
    }
    public boolean onTouchEvent(MotionEvent event){
        left=event.getX();
        right=event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(left,right);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(left,right);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
invalidate();
        return true;
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }
}