package com.example.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputExam {
    public static void main(String[] args) throws Exception{
        User user = new User("bjw1403@gmail.com","jw",1997);
        // /tmp/user.dat에 저장하고 싶다
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/tmp/user.dat"));
        out.writeObject(user); // user를 객체 직렬화시켜서 파일에 저장하게 된다
        out.close();
    }
}
