package com.example.xross.shapestyleapp;

/**
 * Created by Xross on 8/5/16.
 */
import java.util.Vector;

public class ShapeRepository implements ShapeContainer {
    public Vector<Shape> vector;

    public ShapeRepository(Vector shapesVector){
        vector = shapesVector;
    }
    @Override
    public ShapeIterator getIterator(){
        return new ShapesIterator();
    }

    private class ShapesIterator implements ShapeIterator {
        int index;

        @Override
        public boolean hasNext(){
            if(index<vector.size()){
                return true;
            }
            return false;
        }
        @Override
        public Shape next(){
            if(this.hasNext()){
                return vector.get(index++);
            }
            return null;
        }
    }
}
