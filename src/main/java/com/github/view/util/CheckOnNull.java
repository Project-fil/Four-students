package com.github.view.util;


import static com.github.menu.Menu.showMenu;

public class CheckOnNull {

    public static void checkOnNull(String line){
        if(line.isEmpty()){
            System.out.println("Enter command: \n");
            showMenu();
        }
    }
}
