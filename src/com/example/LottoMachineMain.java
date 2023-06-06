package com.example;

public class LottoMachineMain {
    public static void main(String[] args) {
        Ball[] balls = new Ball[LottoMachine.MAX_BALL_COUNT];
        for(int i = 0; i < balls.length; i++){
            balls[i] = new Ball(i + 1);
        }

        // LottoMachine 인스턴스가 생성된다
        LottoMachine lottoMachine = new LottoMachineImpl();
        lottoMachine.setBalls(balls);
        lottoMachine.mix();
        Ball[] result = lottoMachine.getBalls();

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i].getNumber());
        }


    }
}
