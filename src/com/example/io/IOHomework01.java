package com.example.io;

import java.io.*;

/*
    1. txt파일로부터 한줄씩 입력받아 화면에 출력한다.
    2. 키보드로부터 한줄씩 입력받아 파일에 출력한다(파일명은 아규먼트로 받아들인다.)
    3. txt파일로부터 한줄씩 입력받아 다른 파일에 한줄씩 출력한다.
 */
public class IOHomework01 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("사용법 : java FileInfo 파일이름");
            System.exit(0); // return;
        } // if end

        File file = new File(args[0]);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            try {
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }catch (IOException ex){
                System.out.println(ex);
            }


        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }


    }

}
