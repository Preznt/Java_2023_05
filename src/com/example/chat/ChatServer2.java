package com.example.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer2 {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        // ArrayList 메소드에 동시에 접근하지 못하도록 하는 List가 만들어진다.
        List<ChatThread2> list = Collections.synchronizedList(new ArrayList<>());

        while (true){
            Socket socket = ss.accept();
            ChatThread2 chatThread2 = new ChatThread2(socket, list);
            chatThread2.start();
        } // while



    }

}
