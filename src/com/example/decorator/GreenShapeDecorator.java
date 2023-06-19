package com.example.decorator;

public class GreenShapeDecorator extends ShapeDecorator{
    public GreenShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("Green ============= Start");
        decoratedShape.draw();
        System.out.println("Green ============= End");
    }


}
