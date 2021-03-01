package com.github.project.checks;

import static com.github.project.dao.DaoMenu.showMenu;

public class CheckOnNull {

    public static void checkOnNull(String line){
        if(line.isEmpty()){
            System.out.println("Enter command: \n");
            showMenu();
        }
    }
}
