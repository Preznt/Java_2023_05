package com.example.crm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class UserUI {
    private BufferedReader br;
    public UserUI(){
        br= new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu(){
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 목록 보기");
        System.out.println("3. 회원 정보 수정");
        System.out.println("4. 회원 삭제");
        System.out.println("5. 종료");

        int menuId = -1;
        try {
            String line = br.readLine();
            menuId = Integer.parseInt(line); // 문자열을 정수로 변환
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return  menuId;
    }

    public User regUser(){
        try {
            System.out.println("이메일을 입력하세요");
            String email = br.readLine();
            System.out.println("이름을 입력하세요");
            String name = br.readLine();
            System.out.println("생년월일을 입력하세요");
            String strBirthYear = br.readLine();
            int birthYear = Integer.parseInt(strBirthYear);

            User user = new User(email, name, birthYear);
            return user;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public void printUserList(List<User> users){
        System.out.println("이메일           이름            생년");
        System.out.println("=================================");
        for(int i = 0 ; i < users.size() ; i++){
            User user = users.get(i);
            System.out.print(user.getEmail());
            System.out.print("          ");
            System.out.print(user.getName());
            System.out.print("          ");
            System.out.print(user.getBirthYear());
            System.out.println();
        }
    }

    public void updateUser(){

    }

    public void deleteUser(){
        UserDao userDao = new UserDao("/tmp/users.dat");
        try {
            System.out.println("삭제할 이메일을 입력해주세요");
            String dEmail = br.readLine();

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

}
