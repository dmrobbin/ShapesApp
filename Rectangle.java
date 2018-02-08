package com.example.xross.shapestyleapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.content.Context;
import java.util.Random;
import android.graphics.Rect;
import android.graphics.Color;

public class Rectangle extends Shape {


    Random rand =  new Random();
    Paint fill = new Paint();
    Paint border = new Paint();
    Rect r = new Rect(rand.nextInt(100)+100, rand.nextInt(400)+200,
            rand.nextInt(700)+300, rand.nextInt(1000)+400);


    public Rectangle(Context context,Paint x, Paint y){
        super(context);
        fill=x;
        border=y;
    }

    public String getShapeType(){
        return "Rectangle";
    }

    @Override
    public void onDraw(Canvas canvas){
        Random rand = new Random();

        // fill
        fill.setAlpha(100);
        border.setAlpha(100);
        fill.setStyle(Paint.Style.FILL);
        canvas.drawRect(r, fill);

        // border
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(10);
        canvas.drawRect(r, border);


    }



}
