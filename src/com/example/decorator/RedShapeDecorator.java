package com.example.decorator;

public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("Red ============= Start");
        decoratedShape.draw();
        System.out.println("Red ============= End");
    }


}
