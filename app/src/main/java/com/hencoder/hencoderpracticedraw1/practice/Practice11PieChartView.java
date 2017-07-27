package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        drawPie(canvas, Color.WHITE, 0, 180);// 画饼图
        drawPie(canvas, Color.BLACK, 180, 10);// 画饼图
        drawPie(canvas, Color.YELLOW, 190, 50);// 画饼图
        drawPie(canvas, Color.GREEN, 240, 30);// 画饼图
        drawPie(canvas, Color.BLUE, 270, 90);// 画饼图
    }
    private void drawPie(Canvas canvas, int color, float startAngle, float endAngle) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            paint.setColor(color);
            canvas.drawArc(100, 100, 500, 500, startAngle, endAngle, true, paint);
        }
    }
}
