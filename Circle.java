package com.example.xross.shapestyleapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.content.Context;

import android.graphics.Color;

import java.util.Random;

public class Circle extends Shape {

    Random rand =  new Random();
    Paint fill = new Paint();
    Paint border = new Paint();



    public Circle(Context context,Paint x, Paint y){
        super(context);
        fill=x;
        border=y;
    }

    public String getShapeType(){
        return "Circle";
    }


    @Override
    public void onDraw(Canvas canvas){
        Random rand = new Random();
        Float x = rand.nextFloat()*(800-300)+300;
        Float y = rand.nextFloat()*(1200-300)+300;
        Float r = rand.nextFloat()*(300-100)+100;
        fill.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x,y,r,fill);

        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(10);
        canvas.drawCircle(x,y,r,border);

    }




}
