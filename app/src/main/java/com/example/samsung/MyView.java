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
    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }
    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }
    void drawBalls(Canvas canvas)
    {
        Paint paint = new Paint();
        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(re,gr,bl));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x[i], y[i], rad, paint);
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8);
            canvas.drawCircle(x[i], y[i], rad, paint);

        }
        if(re==255&&gr==0&&bl!=255){bl+=5;}
        else if(re==0&&gr!=255&&bl==255){gr+=5;}
        else if (re==0&&gr==255&&bl!=0){bl-=5;}
        else if (re!=255&&gr==255&&bl==0){re+=5;}
        else if (re==255&&gr!=0&&bl==0){gr-=5;}
        else if(re!=0&&gr==0&&bl==255){re-=5;}


    }
    void addValues(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }
    public MyView(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 15);
        fillRandom(vy,0, 15);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        drawBalls(canvas);
        addValues(x, vx);
        addValues(y, vy);
        for (int i = 0; i < N; i++) {
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
        invalidate();
    }
}