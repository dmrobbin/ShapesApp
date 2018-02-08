package com.example.xross.shapestyleapp;

import android.content.Context;
import android.view.View;
import java.util.Iterator;

import android.graphics.Canvas;
abstract class Shape extends View {


    public Shape(Context context){
        super(context);
    }


    void setShapeAlpha(float Alpha){
        setAlpha(Alpha);
    }

    float getShapeAlpha(){
        return getAlpha();

    }

    void removeShape(){
        setVisibility(View.GONE);
    }

    abstract String getShapeType();

    @Override
    public abstract void onDraw(Canvas canvas);


}
