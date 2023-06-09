package com.example.crm;

import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/tmp/users.dat");
        List<User> users = userDao.loadUsers(); // 메모리상에 User정보를 관리한다.
        UserService userService = new UserServiceInMemory(userDao.loadUsers());


        while(true){
            int menuId = userUI.menu();

            if(menuId == 5){
                System.out.println("종료합니다");
                userDao.saveUser(userService.getUsers());
                break;
            } else if (menuId == 1) {
                User user = userUI.regUser();
                users.add(user);
                System.out.println("등록되었습니다");
            } else if (menuId == 4) {
                String email = userUI.inputEmail();
                int findIndex = -1;

                for(int i = 0; i < users.size(); i++){
                    if(users.get(i).getEmail().equals(email)){
                        findIndex = i;
                        break;
                    }
                }
                if(findIndex != -1){
                    users.remove(findIndex);
                    System.out.println("삭제 되었습니다");
                }else {
                    System.out.println("삭제할 회원정보가 없습니다");
                }
            } else if (menuId == 2) {
                userUI.printUserList(userService.getUsers());
            } else if (menuId == 3) {
                String email = userUI.inputEmail();
                int findIndex = -1;

                for(int i = 0; i < users.size(); i++){
                    if(users.get(i).getEmail().equals(email)){
                        findIndex = i;
                        break;
                    }

                }
                if(findIndex != -1){
                    User user = userUI.inputUser(email);
                    users.remove(findIndex);
                    users.add(user);
                }else {// 찾지 못하였다
                    System.out.println("수정할 회원정보가 없습니다.");
                }


            }
        }


    }
}
