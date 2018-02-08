package com.example.xross.shapestyleapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Xross on 7/8/16.
 */
public class GreenPurpleShapeFactory extends AbstractFactory {

    Paint border = new Paint();
    Paint fill = new Paint();

    int getFillColor(){
        return (Color.MAGENTA);
    }
    int getBorderColor(){
        return (Color.GREEN);
    }

    Shape getShape(Context context, String Shape) {
        border.setColor(Color.GREEN);
        fill.setColor(Color.MAGENTA);

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