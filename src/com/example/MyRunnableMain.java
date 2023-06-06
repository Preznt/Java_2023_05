package com.example;

public class MyRunnableMain {
    public static void main(String[] args) {
        MyRunnable m = new MyRunnable() {
            @Override
            public void run() {
                System.out.println("myrunnable run!");
            }
        };

        m.run();

    }
}
