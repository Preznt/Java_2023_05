package com.example.chat;

import java.io.*;
import java.net.Socket;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ChatThread extends Thread{
    private Socket socket;
    private List<PrintWriter> outList;
    private PrintWriter out;
    private BufferedReader in;

    public ChatThread(Socket socket, List<PrintWriter> outList) {
        this.socket = socket;
        this.outList = outList;

        // 1. socket으로 부터 읽어들일 수 있는 객체를 얻는다.
        // 2. socket에게 쓰기 위한 객체를 얻는다.
        try {
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 공유객체이므로 다른 Thread에서도 추가된걸 알 수 있다.
            outList.add(out);
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }

    @Override
    public void run() {
        // 3. 클라이언트가 보낸 메시지를 읽는다.
        // 4. 접속된 모든 클라이언트 들에게 메시지를 보낸다.(현재 연결된 클라이언트에게 쓰는 객체)
        String line = null;
        try {
            while ((line = in.readLine()) != null){
                for(int i =0; i < outList.size(); i++){ // 접속한 모든 클라이언트에게 메시지를 전송한다.
                    PrintWriter o = outList.get(i);
                    o.println(line);
                    o.flush();

                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                outList.remove(out);
            }catch (Exception ex){
                ex.printStackTrace();
            }

            for(int i =0; i < outList.size(); i++){
                PrintWriter o = outList.get(i);
                o.println("어떤 클라이언트의 접속이 끊어졌어요");
                o.flush();
            }

            try {
                socket.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
    }
}
