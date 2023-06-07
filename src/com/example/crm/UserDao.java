package com.example.crm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 파일에서 List<User> 정보를 저장하거나 읽어오는 기능
 */
public class UserDao {
    private String filename;

    public UserDao(String filename){
        this.filename = filename;
    }
    // 그냥 User 형태의 정보를 저장하면 안되는가?
    public void saveUser(List<User> list){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(list);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    // 만약 특정 이름, 이메일, 생년월일을 입력시 해당 데이터가 나오게 만든다면?
    public List<User> loadUsers(){
        File file = new File(filename);
        if(!file.exists()){
            return new ArrayList<>();
        }

        List<User> list = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            list = (List<User>) in.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

}
