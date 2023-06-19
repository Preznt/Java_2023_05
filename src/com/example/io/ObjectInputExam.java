package com.example.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputExam {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/tmp/user.dat"));
        User user = (User) in.readObject(); // 파일로부터 인스턴스 정보를 읽어들여서 인스턴스를 만들어내고 그것을 user에 담아줌
        in.close();

        System.out.println(user);
    }
}
