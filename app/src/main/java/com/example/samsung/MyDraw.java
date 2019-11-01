package com.example.samsung;
import android.content.Context;
import android.graphics.*;
import android.view.View;
public class MyDraw extends View {
    float[] points1;
    MyDraw(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        canvas.drawColor(Color.BLACK);
        paint.setStrokeWidth(5);
        float width = 400;
        float height = 240;
        float radius = 150;
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        float center_x, center_y;
        center_x = 240;
        center_y = 220;
        final RectF oval = new RectF();
        oval.set(center_x - radius, center_y - radius, center_x + radius,
                center_y + radius);
        canvas.drawArc(oval, 45, 270, true, paint); // рисуем пакмана
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(230, 150, 15, paint);
        paint.setColor(Color.YELLOW);
        float cx = 400, cy = 220;
        while (cy < getHeight()) {
            while (cx < getWidth()) {
                canvas.drawCircle(cx, cy, 30, paint);
                cx += 110;
            }
            cx=400;
            cy+=400;
        }
        cx = 400; cy = 620;
        while (cy < getHeight()) {
            while (cx >0) {
                canvas.drawCircle(cx, cy, 30, paint);
                cx -= 110;
            }
            cx=400;
            cy+=400;
        }
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(50);
        cy=450;
        canvas.drawLine(0, cy, this.getWidth(), cy, paint);
        cy=850;
        canvas.drawLine(0, cy, this.getWidth(), cy, paint);
        cy=1250;
        canvas.drawLine(0, cy, this.getWidth(), cy, paint);

    }



    }



