package com.example.io;

import java.io.*;

public class IOHomework02 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if(args.length != 1){
            System.out.println("사용법 : java FileInfo 파일이름");
            System.exit(0); // return;
        } // if end

        File file = new File(args[0]);

        try {
            BufferedWriter bw = new BufferedWriter( new FileWriter(file));
            bw.write(br.readLine());
            bw.close();
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
