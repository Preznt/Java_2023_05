package src.example.fw;
/*
여러 종류의 Controller를 만들 생각
초기화 - 같은 코드
실행 - 다른 코드
마무리 - 같은 코드
 */
public abstract class Controller {
    // protected 는 같은 패키지이거나 상속받았을 경우에 접근 가능하다.
    protected final void init(){
        System.out.println("초기화 코드");
    }

    protected abstract void run(); // 매번 다른 코드

    protected final void  close(){
        System.out.println("마무리 코드");
    }

    // 어떤 순서를 가지고 있다. 이런 메소드를 템플릿 메소드라고 한다.
    public void execute(){
        this.init(); // this 생략가능
        this.run();
        this.close();
    }
}
