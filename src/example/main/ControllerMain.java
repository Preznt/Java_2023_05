package src.example.main;

import src.example.fw.Controller;
import src.example.myproject.FirstController;

public class ControllerMain {
    public static void main(String[] args){
        Controller c1 = new FirstController();
        c1.execute();
    }
}
