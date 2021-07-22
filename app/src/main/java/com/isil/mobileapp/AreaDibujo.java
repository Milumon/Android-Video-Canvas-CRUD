package com.isil.mobileapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AreaDibujo extends View {

    // setup initial color
    private final int paintColor = Color.BLACK;
    // defines paint and canvas

    private Paint drawPaint;
    private Paint drawPaintWhite;
    private Boolean isDrawed;

    private List<Point> circlePoints;
    private List<Paint> drawPaints;



    public AreaDibujo(Context context, AttributeSet attrs) {
        super(context, attrs);
        circlePoints = new ArrayList<Point>();
        drawPaints = new ArrayList<Paint>();
        isDrawed = false;

    }


    @Override
    protected void onDraw(Canvas canvas) {

        if (isDrawed){
            canvas.drawColor(Color.WHITE);
            isDrawed = false;
        }

        int i = 0;
        for (Point p : circlePoints) {

            canvas.drawCircle(p.x, p.y, 100, drawPaints.get(i++));
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        drawPaint = new Paint();
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        Random random = new Random();
        int rojo = random.nextInt(255);
        int verde = random.nextInt(255);
        int azul = random.nextInt(255);
        drawPaint.setARGB(255, rojo, verde, azul);
        drawPaints.add(drawPaint);
        circlePoints.add(new Point(Math.round(touchX), Math.round(touchY)));
        // indicate view should be redrawn
        postInvalidate();
        return true;
    }
}
