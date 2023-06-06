
public class Bus2 extends Car2 {
    public Bus2() {
//        super(); 부모의 기본생성자를 호출하는 코드가 자동으로 삽입된다.
        super("Bus!"); // 아래는 Car2의 생성자에 매개변수로 name을 받기 때문에
        System.out.println("src.Bus2 생성자 호출");
    }

    // 부모가 가지고 있는 추상메소드는 자식에서 반드시 구현을 해줘야 한다.
    @Override
    public void run() {
        System.out.println("후륜구동으로 동작한다 ");
    }
}
