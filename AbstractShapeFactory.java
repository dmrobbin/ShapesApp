package com.example.xross.shapestyleapp;

import android.content.Context;


public class AbstractShapeFactory {

    static AbstractFactory getShapeFactory(int style){
        if(style==1){
            return new RedBlueShapeFactory();
        }else if(style==2){
            return new GreenPurpleShapeFactory();
        }else{
            return new BlackWhiteShapeFactory();
        }

    }

}
