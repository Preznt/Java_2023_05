package com.example;

import java.lang.reflect.Method;

public class ClassLoaderMain {
    public static void main(String[] args) throws Exception{
        // a() 메소드를 가지고 있는 클래스가 있다.
        // 이 클래스 이름이 무엇인지 모르겠다.
        // 나중에 이 클래스 이름을 알려주겠다.
        // a() 메소드를 실행할 수 있는 코드를 작성해라.

        // Bus b1 = new Bus();
        // b1.a();

        // className에 해당하는 클래스 정보를 CLASSPATH에서 읽어들이고,
        // 그 정보를 clazz가 참조하도록 한다.
        String className = "com.example.Bus";
        Class clazz = Class.forName(className);
        // 클래스 정보를 가지고 인스턴스를 만들어라
        Object o = clazz.newInstance();
        // Bus b = (Bus)o;
        // b.a();

        Method m = clazz.getDeclaredMethod("a",null); // a() 메소드 정보를 가지고 있는 Method를 반환하라
        m.invoke(o, null); // m이라는 정보를 이용해서 실행하라, Object o가 참조하는 객체의 m메소드를 실행하라.
    }
}
