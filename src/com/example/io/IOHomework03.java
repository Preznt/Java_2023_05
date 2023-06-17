package com.example.io;

import java.io.*;

public class IOHomework03 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("사용법 : java FileInfo 파일이름");
            System.exit(0); // return;
        } // if end

        File file = new File(args[0]);
        File file2 = new File("/test2.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
            String line = null;
            try {
                while((line = br.readLine()) != null){
                    bw.write(line);
                }
            }catch (IOException ex){
                System.out.println(ex);
            }
        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }

    }
}
