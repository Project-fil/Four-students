package com.company.adnhz;

import java.util.Scanner;

public class Menu {

    public static final String menuCrudHelpers = "Select action: \nEnter 1 for CRUD " +
            "\nEnter 2 for HELPERS \n ";
    public static final String menuCrud = "Select action: \nEnter 1 for Create " +
            "\nEnter 2 for ReadAll \nEnter 3 for Update " +
            "\nEnter 4 for Delete \n ";
    public static final String fileType = "Select a file type: \nEnter 1 for JSON " +
            "\nEnter 2 for XML \nEnter 3 for CSV " +
            "\nEnter 4 for YAML \nEnter 5 for Binary \n";
    public static final String menuHelpers = "Select action: \nEnter 1 for Help" +
            "\nEnter 2 for Switch \nEnter 3 for Exit \n";
    public static final Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        boolean flagfor = true;
        while (flagfor) {
            System.out.println(menuCrudHelpers);
            String typeOfAction = scanner.next();
            if (typeOfAction.equals("1")) {
                System.out.println(menuCrud);
                String action = scanner.next();
                System.out.print(fileType);
                String typeOfFile = scanner.next();
                boolean flag = true;
                String ac = null;
            } else if (typeOfAction.equals("2")) {
                System.out.println(menuHelpers);
            }
        }
    }
}
