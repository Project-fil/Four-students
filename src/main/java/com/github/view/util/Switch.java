package com.github.view.util;

import static com.github.menu.Menu.showMenu;

public class Switch {

    public static void switchToMenuCheck(String line) {
        if (line.equals("switch")) {
            System.out.println();
            showMenu();

        }
    }
}
