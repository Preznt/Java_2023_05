package com.example.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient2 {
    public static void main(String[] args) throws Exception{
        if(args.length != 1){
            System.out.println("사용법 : java com.example.chat.ChatClient2 닉네임;");
            return;
        }
        String name = args[0];

        Socket socket = new Socket("127.0.0.1", 8888);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));

        // 닉네임 전송
        out.println(name);
        out.flush();

        // 백그라운드로 서버가 보내준 메시지를 읽어들여서 화면에 출력한다.
        InputThread2 inputThread2 = new InputThread2(in);
        inputThread2.start();

        // 클라이언트는 읽어들인 메시지를 서버에 전송한다.
        try {
            String line = null;
            while ((line = keyBoard.readLine()) != null) {
                if ("/quit".equals(line)){
                    out.println("/quit");
                    out.flush();
                    break;
                }
                out.println(line);
                out.flush();
            }
        }catch (Exception ex){
            System.out.println("....");
        }

        try {
            in.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            socket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}

class InputThread2 extends Thread {
    BufferedReader in;

    public InputThread2(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String line = null;
            while ((line = in.readLine())!= null){
                System.out.println(line);
            }
        }catch (Exception ex){
            System.out.println(".....");
        }
    }
}