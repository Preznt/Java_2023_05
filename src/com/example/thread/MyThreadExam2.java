package com.example.thread;

public class MyThreadExam2 {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println("thread name : " + name);
        System.out.println("start!");

        MyRunnable mr1 = new MyRunnable("*");
        MyRunnable mr2 = new MyRunnable("+");

        // 3. Thread인스턴스를 생성하는데, 생성자에 Runnable인스턴스 넣어준다.
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);

        // 4. Thread가 가지고있는 start()메소드를 호출한다.
        t1.start();
        t2.start();

        System.out.println("end");
    }


}
