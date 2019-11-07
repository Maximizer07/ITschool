package com.example.samsung;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import static android.graphics.Color.rgb;
public class MyView extends View {
    int N = 6; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    int re=255,gr=0,bl=0;
    float rad = 40;

    public MyView(Context context) {
        super(context);
        for (int i = 0; i < N; i++){
            x[i] = (float)(Math.random() * 500);
            y[i] = (float)(Math.random() * 500);
            vx[i] = (float)(Math.random() * 9 - 3);
            vy[i] = (float)(Math.random() * 9 - 3);
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Здесь располагаются команды рисования
        ///...
        Paint paint = new Paint();
        // отрисовываем все шарики
        canvas.drawColor(Color.BLACK);
        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(re,gr,bl));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x[i], y[i], rad, paint);
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8);
            canvas.drawCircle(x[i], y[i], rad, paint);
        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
            if (x[i] < 0 || x[i] > this.getWidth()){
                vx[i] = - vx[i];
            }
            if (y[i] < 0 || y[i] > this.getHeight()){

                vy[i] = - vy[i];

            }
        }
        for (int i = 0; i < N; i++)
        {
            if (vx[i] > 0)
                rad += 0.08;
            else
                rad -= 0.08;
        }
        if(re==255&&gr==0&&bl!=255){bl+=5;}
        else if(re==0&&gr!=255&&bl==255){gr+=5;}
        else if (re==0&&gr==255&&bl!=0){bl-=5;}
        else if (re!=255&&gr==255&&bl==0){re+=5;}
        else if (re==255&&gr!=0&&bl==0){gr-=5;}
        else if(re!=0&&gr==0&&bl==255){re-=5;}
        //запрашиваем перерисовку
        invalidate();
    }
}