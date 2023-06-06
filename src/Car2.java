
public abstract class Car2 {
//    public Car2() {
//        super(); // 자동으로 들어간다
//        System.out.println("Car2 생성자 호출");
//    }

    /**
     *  만약 Car2가 기본생성자가 아니라 name을 매개변수로 받는 생성자를 만들게 되면
     *  생성자가 하나라도 만들어지면 기본생성자는 만들어지지 않으므로
     *  Car2를 상속받는 Bus2에는 super("Bus");코드를 작성해주어야 한다
     */
    public Car2(String name) {
        super(); // 자동으로 들어간다
        System.out.println("Car2 생성자 호출");
    }

    // 추상 메소드, Car2를 만든 람은 run()이라는 메소드가 필요하다고 생각을 했다
    // run()은 자동차마다 다르게 구현할 것 같을 떄 사용
    public abstract void run();
}
