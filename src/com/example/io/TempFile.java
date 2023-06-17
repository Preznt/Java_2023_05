package com.example.io;

import java.io.File;
import java.io.IOException;

public class TempFile {
    public static void main(String[] args) {
        try {
            File f = File.createTempFile("tmp_", ".dat");
            System.out.println(f.getAbsolutePath());
            System.out.println("60초 동안 멈춰있습니다");
            try {
                Thread.sleep(60000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            f.deleteOnExit(); // JVM이 종료될 떄 임시파일을 자동으로 삭제한다.

        }catch (IOException e){
            System.out.println(e);
        }


    }
}
