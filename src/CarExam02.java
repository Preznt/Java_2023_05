package src;

public class CarExam02 {
    public static void main(String[] args){
        Car c1 = new Car();
        System.out.println(c1); // println(Object x) - Object로 참조할 수 있는 것은 무엇이든 받을 수 있다

    }
}

// 부모타입의 변수로 자식인스턴스를 참조할 수 있다
// Car c1 = new Bus();
// Car c2 = new 이층버스();
// Object o1 = new Car();
// Object o2 = new 이층버스();
// System.out.println(o1.toString()); == System.out.println(o1);