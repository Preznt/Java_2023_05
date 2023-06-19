package com.example.io;

import java.io.*;
import java.util.ArrayList;

public class ObjectInpuOutExam {
    public static void main(String[] args) throws Exception {
        User user1 = new User("hong@example.com", "홍길동", 1997);
        User user2 = new User("go@example.com", "고길동", 1993);
        User user3 = new User("goro@example.com", "고로", 1992);

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        ArrayList<User> list2 = copy(list);

        list.remove(2);

        System.out.println(list2);


    }

    // 객체 직렬화를 이용한 객체 복사 
    private static ArrayList<User> copy(ArrayList<User> list) throws IOException, ClassNotFoundException {
        // list 와 함께 list에 포함된 user까지 직렬화가 돼서 ObjectOutputStream을 통해서 써주게 되는데
        // ObjectOutputStream은 ByteArrayOutputStream가 가지고있는 write메소드를 이용해서 ByteArrayOutputStream의 메모리에 써주게 된다
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(list);
        out.close();
        bout.close();

        byte[] array = bout.toByteArray(); //  list 자체가 직렬화 되어서 byte배열이 된 것

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(array));
        ArrayList<User> list2= (ArrayList)in.readObject();
        in.close();
        return list2;
    }
}
