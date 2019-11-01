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
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        float x = 0;float y =0;
        while (x<getHeight()){
            canvas.drawLine(x,0,0,y,paint);
            x+=30;
            y+=30;
        }
        float z=0;
        while (z < canvas.getHeight()){z +=1; }

        while (x<z*2){
            canvas.drawLine(x,0,0,y,paint);
            x+=30;
            y+=30;
        }



    }
    }


