package com.github.project;

import com.github.project.dao.DaoMenu;

public class Main {

    public static void main(String[] args) {
        try { DaoMenu.showMenu();
        } catch (Throwable t) {
            System.out.println("Restart Program");
        }
    }
}
