package com.company;

import com.company.utils.Menu;

public class Main {

    public static void main(String[] args) {
        try { Menu.showMenu();
        } catch (Throwable t) {
            System.out.println("Restart Program");
        }
    }
}





