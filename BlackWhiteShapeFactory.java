package com.example.xross.shapestyleapp;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Color;

public class BlackWhiteShapeFactory  extends AbstractFactory {

    Paint border = new Paint();
    Paint fill = new Paint();

    int getFillColor(){
        return (Color.WHITE);
    }
    int getBorderColor(){
        return (Color.BLACK);
    }

    Shape getShape(Context context, String Shape) {
        border.setColor(Color.BLACK);
        fill.setColor(Color.WHITE);

        if (Shape == null) {
            return null;
        }
        if (Shape.equals("Rectangle")) {
            return new Rectangle(context,fill,border);
        }
        if (Shape.equals("Circle")) {
            return new Circle(context,fill,border);
        } else if (!Shape.equals("Circle") | !Shape.equals("Rectangle")) {
            return null;
        }
        return null;
    }
}