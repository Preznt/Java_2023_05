package com.example.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressExam {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getLocalHost(); // 자신의 컴퓨터 IP정보를 구한다.
            System.out.println(ia.getHostAddress());
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }

        try {
            InetAddress[] iaArray = InetAddress.getAllByName("www.google.com");
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }


    }
}
