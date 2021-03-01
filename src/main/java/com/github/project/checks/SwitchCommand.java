package com.github.project.checks;

import static com.github.project.dao.DaoMenu.showMenu;

public class SwitchCommand {

    public static void switchToMenuCheck(String line) {
        if (line.equals("switch")) {
            System.out.println();
            showMenu();

        }
    }
}
