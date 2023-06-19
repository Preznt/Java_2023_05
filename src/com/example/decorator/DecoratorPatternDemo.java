package com.example.decorator;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class DecoratorPatternDemo {
    public static void main(String[] args) throws Exception{
//        Circle circle = new Circle();
//        RedShapeDecorator redCircle = new RedShapeDecorator(circle);
//
//        redCircle.draw();

        Shape shape = new GreenShapeDecorator(new RedShapeDecorator(new Circle()));
        shape.draw();

        // Shape ===> InputStream (추상클래스)
        // Circle ===> FileInputStream
        // RedShapeDecorator =====> DataInputStream
        InputStream in = new DataInputStream(new FileInputStream("a.txt"));
    }
}
