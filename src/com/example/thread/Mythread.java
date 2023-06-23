package com.example.thread;

// 1.Thread를 상속받는다
public class Mythread extends Thread{
    // 2. run() 메소드를 오버라이딩 한다.
    private String str;

    public Mythread(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        // 동시에 실행시키고 싶은 코드를 작성한다.
        for(int i = 0; i < 10; i++){
            System.out.println(str);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }

        }
    }
}
