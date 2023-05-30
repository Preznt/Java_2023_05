package src;

public class Car2Exam02 {
    public static void main(String[] args){
//        Car2 c2 = new Car2("bjw");
        Bus2 b = new Bus2();
        b.run();

        SportsCar s1 = new SportsCar("bjw");
        s1.run();

        // 자동차의 배열이라는 뜻은 자동차의 후손들을 참조할 수 있는 배열이다
        Car2[] array = new Car2[2];
        array[0] = new Bus2();
        array[1] = new SportsCar("sportsCar");
        for(Car2 c2 : array){
            c2.run();
        }
    }
}
