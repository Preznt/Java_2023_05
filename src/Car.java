
public class Car {
    private String name;
    public Car(){
        System.out.println("자동차를 한대 생성합니다");
    }

    // 이름을 가지고 인스턴스가 만들어지게 하고 싶다
    public Car(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("전륜구동으로 달린다");
    }

    @Override
    public String toString() {
        return "자동차!";
    }
}
