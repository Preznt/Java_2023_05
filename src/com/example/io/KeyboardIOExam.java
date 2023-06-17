package com.example.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardIOExam {
    public static void main(String[] args) throws Exception{
        // 키보드로부터 한 줄씩 입력받고, 한 줄씩 화면에 출력하시오.
        // 키보드 : System.in (InputStream 주인공)
        // 화면에 출력 : System.out(PrintStream 주인공)
        // 키보드로 입력받는 건 문자를 입력받는 다는 것 : char 단위 입출력
        // char 단위 입출력 클래스는 Reader, Writer
        // 한줄 읽기 : BufferedReader라는 클래스는 readLine이라는 메소드를 가지고 있다.
        //          더이상 읽어들일 것이 없으면(EOF) null을 반환
        // 한줄 쓰기 : PrintStream, PrintWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while((line = br.readLine()) != null){
            System.out.println("읽어들인 값: " + line);
        }


    }
}
