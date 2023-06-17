package com.example.collectionfw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListExam03 {
    public static void main(String[] args) {
        // 앞에도 클래스 타입 뒤에도 클래스 타입이면 안된다 앞에는 인터페이스 타입을 사용하고 뒤에만 클래스 타입을 사용해야한다
        // 컬렉션을 구현하고 있는 자료구조 객체들이 올 수 있다
        Collection<String> collection = new ArrayList<>();
        collection.add("kim");
        collection.add("min");
        collection.add("hong");

        System.out.println(collection.size());

        Iterator<String> iterator = collection.iterator();
        // 이 부분에서 순서대로 나오는 이유는 지금 ArrayList로 인스턴스를 생성했기 때문
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }

    }
}
