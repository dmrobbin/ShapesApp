package com.example.xross.shapestyleapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;


public class RedBlueShapeFactory extends AbstractFactory {

    Paint border = new Paint();
    Paint fill = new Paint();

    int getFillColor(){
        return (Color.BLUE);
    }
    int getBorderColor(){
        return (Color.RED);
    }

    Shape getShape(Context context, String Shape) {
        border.setColor(Color.RED);
        fill.setColor(Color.BLUE);

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
