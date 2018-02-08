package com.example.xross.shapestyleapp;

import android.content.Context;

public abstract class AbstractFactory {
    abstract Shape getShape(Context context, String shape);

    abstract int getFillColor();
    abstract int getBorderColor();
}
