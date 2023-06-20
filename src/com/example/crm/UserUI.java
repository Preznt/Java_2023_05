package com.example.crm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
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

    public void printUserList(Iterator<User> iter){
        System.out.println("이메일           이름            생년");
        System.out.println("=================================");
        while(iter.hasNext()){
            User user = iter.next();
            System.out.print(user.getEmail());
            System.out.print("          ");
            System.out.print(user.getName());
            System.out.print("          ");
            System.out.print(user.getBirthYear());
            System.out.println();
        }
    }

    public String inputEmail(){
        System.out.println("email을 입력하세요");
        String email = "";
        try {
            email = br.readLine();
        }catch (IOException ex){
            System.out.println(ex);
        }
        return email;
    }

    public User inputUser(String email){
        try {
            System.out.println(email + "의 회원정보를 수정합니다");
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


//    public void deleteUser(List<User> list){
//        try {
//            System.out.println("삭제할 이메일을 입력해주세요");
//            String deleteEmail = br.readLine();
//            boolean b = list.get(0).getEmail().equals(deleteEmail);
//            System.out.println(b);
//
//
//            for(int i = 0; i < list.size(); i++){
//                if(list.get(i).getEmail().equals(deleteEmail)){
//                    list.remove(i);
//                    System.out.println("삭제되었습니다.");
//                }else {
//                    System.out.println("삭제에 실패했습니다.");
//                }
//            }
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//
//    }

}
