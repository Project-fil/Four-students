package com.github.menu;

import com.github.view.cruud.CrudDialog;
import com.github.view.util.CheckOnNull;

import static com.github.view.cruud.CrudDelete.safeForFile;

public class Menu {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void showMenu() {
        boolean flagfor = true;
        while (flagfor) {
            System.out.println(ShowMenu.menuCrudHelpers);
            String menuChoise = scanner.next();
            CheckOnNull.checkOnNull(menuChoise);
            try {
                if (menuChoise.equals("1")) {
                    System.out.println(ShowMenu.fileType);
                    while (!scanner.hasNextInt()) {
                        System.out.println("That not a number! Enter number: ");
                        scanner.next();
                    }
                    String typeOfFile = scanner.next();
                    getFileNameByTypeOfFile(typeOfFile);
                    System.out.println(ShowMenu.menuCrud);
                    String crudChoose = scanner.next();
                    CrudDialog.crudMenu(crudChoose, getFileNameByTypeOfFile(typeOfFile));
                }
                if (menuChoise.equals("2")) {
                    System.out.println(ShowMenu.menuHelpers);
                    String helpersChoose = scanner.next();
                    HelperMenu.helpersMethot(helpersChoose);
                } else {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error :) data is written to file");
                System.out.println(e.getMessage());
                safeForFile(menuChoise);
            }
        }
    }

    private static String getFileNameByTypeOfFile(String typeOfFile) {

        if (typeOfFile.equals("1")) {
            return "js.json";
        } else if (typeOfFile.equals("2")) {
            return "xm.xml";
        } else if (typeOfFile.equals("3")) {
            return "cv.csv";
        } else if (typeOfFile.equals("4")) {
            return "ya.yaml";
        } else if (typeOfFile.equals("5")) {
            return "binary.bin";
        } else if (typeOfFile.equals("6")) {
            showMenu();
        } else {
            showMenu();
            System.out.println("Error enter. Try again: ");
        }
        return "";
    }
}
