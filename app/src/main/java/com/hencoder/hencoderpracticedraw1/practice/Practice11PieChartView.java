package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

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
    private int num = 1;// 饼图个数

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        num = 1;
        paint.setStyle(Paint.Style.FILL);
        float startAngle1 = 0;
        float sweepAngle1 = 180;
        drawPie(canvas, Color.WHITE, startAngle1, sweepAngle1);// 画饼图
        float startAngle2 = 180;
        float sweepAngle2 = 10;
        drawPie(canvas, Color.BLACK, startAngle2, sweepAngle2);// 画饼图
        float startAngle3 = 190;
        float sweepAngle3 = 50;
        drawPie(canvas, Color.YELLOW, startAngle3, sweepAngle3);// 画饼图
        float startAngle4 = 240;
        float sweepAngle4 = 30;
        drawPie(canvas, Color.GREEN, startAngle4, sweepAngle4);// 画饼图
        float startAngle5 = 270;
        float sweepAngle5 = 90;
        drawPie(canvas, Color.BLUE, startAngle5, sweepAngle5);// 画饼图
        drawLineAndText(mCircleXY, mCircleXY, getDrawLineAngle(startAngle1, sweepAngle1), canvas);
        drawLineAndText(mCircleXY, mCircleXY, getDrawLineAngle(startAngle2, sweepAngle2), canvas);
        drawLineAndText(mCircleXY, mCircleXY, getDrawLineAngle(startAngle3, sweepAngle3), canvas);
        drawLineAndText(mCircleXY, mCircleXY, getDrawLineAngle(startAngle4, sweepAngle4), canvas);
        drawLineAndText(mCircleXY, mCircleXY, getDrawLineAngle(startAngle5, sweepAngle5), canvas);
    }

    // 获取开始画线的角度
    private float getDrawLineAngle(float startAngle, float sweepAngle) {
        return startAngle + sweepAngle / 2;
    }

    /**
     * 在饼图画线和文字
     *
     * @param x     饼图圆心横坐标
     * @param y     饼图圆心纵坐标
     * @param angle 角度
     */
    private void drawLineAndText(float x, float y, float angle, Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setTextSize(36);
        float startLineX = getStartDrawLinePointX(x, angle);
        float startLineY = getStartDrawLinePointY(y, angle);
        float endLineX = getEndDrawLinePointX(startLineX, angle);
        float endLineY = getEndDrawLinePointY(startLineY, angle);
        Log.e("画饼图", "drawLineAndText: 开始画线的点坐标 x=" + startLineX + " y=" + startLineY);
        Log.e("画饼图", "drawLineAndText: 结束画线的点坐标 x=" + endLineX + " y=" + endLineY);
        canvas.drawLine(startLineX, startLineY, endLineX, endLineY, paint);
        canvas.drawText(String.valueOf(num), endLineX, endLineY, paint);
        num++;
    }

    //             直径       起始点             结束点                     圆心横纵坐标
    private float mD = 400, mStartXY = 180, mEndXY = mD + mStartXY, mCircleXY = mStartXY + mD / 2;

    private void drawPie(Canvas canvas, int color, float startAngle, float sweepAngle) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            paint.setColor(color);
            canvas.drawArc(mStartXY, mStartXY, mEndXY, mEndXY, startAngle, sweepAngle, true, paint);
        }
    }

    private float lineLength = 80;

    /**
     * 获取在饼图上开始画线的点的横坐标
     *
     * @param x0    圆心横坐标
     * @param angle 角度
     * @return 在饼图上开始画线的点的横坐标
     */
    private float getStartDrawLinePointX(float x0, float angle) {
        return (float) (x0 + mD / 2 * Math.cos(angle * 3.14 / 180));
    }

    /**
     * 获取在饼图上开始画线的点的纵坐标
     *
     * @param y0    圆心纵坐标
     * @param angle 角度
     * @return 在饼图上开始画线的点的纵坐标
     */
    private float getStartDrawLinePointY(float y0, float angle) {
        return (float) (y0 + mD / 2 * Math.sin(angle * 3.14 / 180));
    }

    /**
     * 获取在饼图上结束画线的横坐标
     *
     * @param startX 开始画线的横坐标
     * @param angle  角度
     * @return 结束画线的横坐标
     */
    private float getEndDrawLinePointX(float startX, float angle) {
        float endX = mCircleXY;
        if (angle > 0) {
            if (angle < 90 || angle > 270 && angle <= 360) {
                endX = startX + lineLength;
            } else if (angle > 90 && angle < 270) {
                endX = startX - lineLength;
            }
        } else {
            if (angle > -90 || angle < -270 && angle >= -360) {
                endX = startX + lineLength;
            } else if (angle < -90 && angle > -270) {
                endX = startX - lineLength;
            }
        }
        return endX;
    }

    /**
     * 获取在饼图上结束画线的纵坐标
     *
     * @param startY 开始画线的纵坐标
     * @param angle  角度
     * @return 结束画线的纵坐标
     */
    private float getEndDrawLinePointY(float startY, float angle) {
        float endY = mCircleXY;
        if (angle > 0) {
            if (angle < 180) {
                endY = startY + lineLength;
            } else if (angle > 180 && angle < 360) {
                endY = startY - lineLength;
            }
        } else if (angle < 0) {
            if (angle > -180) {
                endY = startY - lineLength;
            } else if (angle < -180 && angle > -360) {
                endY = startY + lineLength;
            }
        }
        return endY;
    }
}
