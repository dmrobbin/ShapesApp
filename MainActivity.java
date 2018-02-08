package com.example.xross.shapestyleapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Shape shape1;
    RelativeLayout canvas;
    Button circleButton;
    Button rectButton;
    Button styButton;
    Button clear;
    String nextStyle;
    Vector<Shape> vector;
    int numberOfCircles;
    int numberOfRectanlges;
    int style; // style 1 = red/blue style 2 = green/purple style 3  = black/white

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        style=1;

        text = (TextView) findViewById(R.id.textView);

        canvas = (RelativeLayout) findViewById(R.id.canvasLayout);
        vector = new Vector<Shape>();
        circleButton = (Button) findViewById(R.id.cButton);
        rectButton = (Button) findViewById(R.id.rectangleButton);
        styButton = (Button) findViewById(R.id.styleButton);
        clear = (Button) findViewById(R.id.clearButton);

        final Context context = this.getApplicationContext();
        updateShapesCount();

        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adjustShapesAlpha();
                makeShape(context, "Circle");

                updateShapesCount();

            } });


        styButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(style==1){
                    style=2;
                }else if(style==2){
                    style=3;
                }else if(style==3){
                    style=1;
                }
                else{
                    style =2;
                }

                updateShapesCount();
            } });

        rectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjustShapesAlpha();
                makeShape(context, "Rectangle");

                updateShapesCount();
            } });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0;i<vector.size();i++){
                    Shape toDelete = vector.get(i);
                    toDelete.setVisibility(View.GONE); //gets rid of all shapes
                }
                vector.clear(); //empties vector
                updateShapesCount();
            } });
    }


    void adjustShapesAlpha(){
        ShapeRepository shapeRepo = new ShapeRepository(vector);
        for (ShapeIterator iter = shapeRepo.getIterator(); iter.hasNext();){
            Shape current = iter.next();
            float currentAlpha=current.getShapeAlpha();
            if (currentAlpha<=0.0f){
                current.removeShape();
                vector.remove(current);
            }else{
                current.setShapeAlpha(currentAlpha-0.1f);
            }
        }


        /*
        if(vector.isEmpty())
            return;
        for (int i = 0; i < vector.size(); i++) { //loop to search though all shapes in vector
            Shape toAdjust = vector.get(i);
            float currentAlpha = toAdjust.getShapeAlpha();

            if(currentAlpha<=0.0f){ //removes vector if it's alpha is 0 or less
                toAdjust.removeShape();
                vector.remove(toAdjust);
            }else {
                toAdjust.setShapeAlpha(currentAlpha - 0.2f);// lowers alpha of each element by 0.2f
            }
        } */
    }

    void updateShapesCount(){
        numberOfCircles=0;
        numberOfRectanlges=0;

        /* if (vector.isEmpty()==false) { //only bothers to count if vector isn't empty
            for (int i = 0; i < vector.size(); i++) { //loop to search though all shapes in vector
                Shape toCount = vector.get(i);
                if (toCount.getShapeType() == "Circle")
                    numberOfCircles += 1; //count circles
                if (toCount.getShapeType() == "Rectangle")
                    numberOfRectanlges += 1; //count rectangles
            }
        } */
        ShapeRepository shapeRepo = new ShapeRepository(vector);

        for (ShapeIterator iter = shapeRepo.getIterator(); iter.hasNext();){
            Shape current = iter.next();
            if(current.getShapeType()== "Circle")
                numberOfCircles+=1;
            if(current.getShapeType()=="Rectangle")
                numberOfRectanlges+=1;
        }

        if(style ==3){
            nextStyle="red/blue";
        }else if(style==1){
            nextStyle="green/purple";
        }else{
            nextStyle="black/white";
        }

        text.setText(numberOfRectanlges+ " Rectangles " +numberOfCircles+ " Circles "+ nextStyle + " next Style");

    }

    void makeShape(Context context, String shape){
        AbstractFactory factory = AbstractShapeFactory.getShapeFactory(style);
        shape1=factory.getShape(context, shape);
        vector.add(shape1);
        shape1.setShapeAlpha(1.0f);
        canvas.addView(shape1);
    }
}