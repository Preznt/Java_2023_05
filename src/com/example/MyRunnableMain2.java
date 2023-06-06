package com.example;

public class MyRunnableMain2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello!!");
            }
        };

        MyRunnableExecute myRunnableExecute = new MyRunnableExecute();
        System.out.println("------------");
        myRunnableExecute.execute(myRunnable);
        // myRunnable이라는 객체를 따로 생성하지 않고 하는 방법
//        myRunnableExecute.execute(new MyRunnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello!!");
//            });
        // 람다
//        myRunnableExecute.execute(()-> {
//                System.out.println("Hello!!");
//            });
        System.out.println("------------");
    }
}
