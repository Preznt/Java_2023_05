package com.example.crm;

import java.util.Iterator;
import java.util.List;

public class UserMain02 {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/tmp/users.dat");
        UserService userService = new UserServiceInMemory(userDao.loadUsers());


        while(true){
            int menuId = userUI.menu();

            if(menuId == 5){
                System.out.println("종료합니다");
                userDao.saveUser(userService.getUsers());
                break;
            } else if (menuId == 1) {
                User user = userUI.regUser();
                userService.addUser(user);
                System.out.println("등록되었습니다");
            } else if (menuId == 4) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);
                if(isFindEmail){
                    userService.deleteUser(email);
                    System.out.println("삭제 되었습니다");
                }else {
                    System.out.println("삭제할 회원정보가 없습니다");
                }
            } else if (menuId == 2) {
                userUI.printUserList(userService.getUsers());
            } else if (menuId == 3) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);
                if(isFindEmail){
                    User user = userUI.inputUser(email);
                    userService.updateUser(user);
                    System.out.println("수정되었습니다.");
                }else {// 찾지 못하였다
                    System.out.println("수정할 회원정보가 없습니다.");
                }


            }
        }


    }
}
