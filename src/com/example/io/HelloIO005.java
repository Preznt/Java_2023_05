package com.example.io;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class HelloIO005 {
    /*
        FileOutputStream 은 "/tmp/my.txt"에 저장한다.
        FileOutputStream 은 write(int) int의 마지막 byte에만 저장한다.
        OutputStreamWriter생성자에 들어온 OutputStream의 write()를 이용하여 쓴다.
        OutputStreamWriter 는  write(int) int의 끝부분 char 저장한다.
        PrintWriter는 생성자에 들어온 OutputStreamWriter의 write()를 이용하여 쓴다.
        PrintWriter는 println(문자열); 문자열을 출력하다.
     */
    public static void main(String[] args) throws Exception{
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/tmp/my.txt")));
        out.println("hello");
        out.println("good");
        out.println("bye");
        out.close();
    }
}
