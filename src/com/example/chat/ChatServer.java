package com.example.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception{

        ServerSocket ss = new ServerSocket(9999);

        // 공유객체에서 스레드에 안전한 리스트를 만든다
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
        while (true){

            Socket socket = ss.accept();
            Thread chatThread = new ChatThread(socket, outList);
            chatThread.start();
        }

    }
}

class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for(int i = 0; i < strlist.length; i++){
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}

class Solution {
    public int[] solution(String[] strList) {
        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
}
