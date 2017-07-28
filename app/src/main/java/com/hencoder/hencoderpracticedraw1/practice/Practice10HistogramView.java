package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        drawCoordinate(canvas);// 画坐标系
        num = 1;
        while (num < 8) {
            drawHistogram(canvas);// 画直方图
        }
    }
    private float mStartX = 100, mEndY = 600f;// 开始X和开始Y坐标
    // 画坐标系
    private void drawCoordinate(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        float[] pts = {mStartX, 100, mStartX, mEndY, mStartX, mEndY, 800, mEndY};
        canvas.drawLines(pts, paint);
    }
    private int num = 1;// 直方图的数量
    private void drawHistogram(Canvas canvas) {
        float interval = 20;// 每个直方图的间隔
        float width = 80;// 直方图的宽
        float startX = num == 1 ? mStartX + num * interval : mStartX + num * interval + (num - 1) * width;// 直方图开始的x坐标
        Log.e("startX", "drawHistogram: " + startX);
        float endX = startX + width;// 每个直方图结束的横坐标
        float startY = new Random().nextFloat() * 500;// 每个直方图开始的纵坐标
        canvas.drawRect(startX, startY, endX, mEndY, paint);
        // 为每个直方图添加文字
        paint.setTextSize(60);
        canvas.drawText(String.valueOf(num), startX + 20, mEndY + 80, paint);
        num++;
    }

}
