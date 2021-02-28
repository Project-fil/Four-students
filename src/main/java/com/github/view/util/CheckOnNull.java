package com.github.view.formatsview;


import static com.github.view.Menu.showMenu;

public class CheckOnNull {

    public static void checkOnNull(String line){
        if(line.isEmpty()){
            System.out.println("Enter command: \n");
            showMenu();
        }
    }
}
