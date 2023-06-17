package com.example.io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamExam01 {
    /*
    1byte가 표현할 수 있는 값 : 00000000 ~ 11111111
    read()메소드가 읽어들일 수 있는 정보 : 0000000 ~ 11111111 중 한개
    1byte씩 파일을 읽어들인다 100byte라면 100번을 읽어들여야한다
    1byte씩 읽어들인다, 파일의 크기를 모른다, 그럼 언제까지 읽어들이냐?
    더이상 읽어들일 것이 없다. EOF

    int에 1byte 값을 담자 00000000 00000000 00000000 00000000
                       00000000 00000000 00000000 11111111
    EOF : -1
    1 --> 00000000 00000000 00000000 00000001
    1의 보수 : 11111111 11111111 11111111 11111110
    2의 보수 : 11111111 11111111 11111111 11111111 : -1
     */
    public static void main(String[] args) {
        InputStream in = null;
    try {
        int b = in.read();
    }catch(IOException ex){
        System.out.println("io 오류 : " + ex);
     // InputStream을 사용하고 나서는 반드시 finally 부분에서 in.close();를 해줘야함
    }finally {
        try {
            in.close();
        } catch (IOException ex2) {
            System.out.println("io  오류2 : " + ex2);
        }

    }
    }
}

