package com.example.chat;

import javax.swing.text.EditorKit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatThread2 extends Thread{
    private Socket socket;
    private String name;
    private BufferedReader in;
    private PrintWriter pw;
    List<ChatThread2> list;

    public ChatThread2(Socket socket, List<ChatThread2>  list) throws Exception{
        this.socket = socket;
        System.out.println(socket);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        this.name = in.readLine();
        this.list = list;
        this.list.add(this);

    }

    public void sendMessage(String msg){
        pw.println(msg);
        pw.flush();
    }

    @Override
    public void run() {
        // broadcast
        // ChatThread는 사용자가 보낸 메시지를 읽어들여서
        // 접속된 모든 클라이언트들에게 메시지를 보낸다.

        try {
            broadCast(name + "님이 접속했습니다", false);

            String line = null;
            while ((line = in.readLine())!= null){
                if("/quit".equals(line)){
                    throw new RuntimeException("접속 종료");
                }
                broadCast(name + " : " + line, true);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            broadCast(name + "님이 연결이 끊어졌습니다." , false);
            this.list.remove(this);
        }finally {
            try {
                in.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }

            try {
                pw.close();
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

    // 연결이 끊어지면 ChatThread하나를 제거한다고 했잖 리스트가 돌아갈때 제거가 되 익셉션 발생
    // 계속해서 메시지를 보내기 위해서 복사를 한것
    private void broadCast(String msg, boolean includeMe){
        List<ChatThread2> chatThreads = new ArrayList<>();
        for(int i = 0; i < this.list.size(); i++) {
            chatThreads.add(list.get(i));
        }
        try {
            for(int i =0; i < chatThreads.size() ; i++){
                ChatThread2 ct = chatThreads.get(i);
                if(!includeMe){ // 나를 포함하지 말아라.
                    if(ct == this){
                        continue;
                    }
                }
                ct.sendMessage(msg);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
