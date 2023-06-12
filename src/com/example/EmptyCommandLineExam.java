package com.example;

public class EmptyCommandLineExam {
    public static void main(String[] args) {
        System.out.println(args);
    }
}

// String[] args = new String[0];
// main(args);

// javac EmptyCommandLineExam.java
// 공백을 기준으로 배열이 만들어짐
// java EmptyCommandLineExam a b c d Hello;
// java javaagent:어떤설정 EmptyCommandLineExam a b c
// 어떤 설정은 JVM 자체에 주는 옵션이다

