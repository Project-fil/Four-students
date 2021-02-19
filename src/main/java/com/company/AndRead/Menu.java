
package com.company.AndRead;

import java.io.*;
import java.util.Scanner;


public class Menu {

    public static final String menuCrudHelpers = "Select action: \nEnter 1 for CRUD " +
            "\nEnter 2 for HELPERS \n ";

    public static final String menuCrud = "Select action: \nEnter 1 for Create " +
            "\nEnter 2 for ReadAll \nEnter 3 for Update " +
            "\nEnter 4 for Delete \n ";

    public static final String fileType = "Select a file type: \nEnter 1 for JSON " +
            "\nEnter 2 for XML \nEnter 3 for CSV " +
            "\nEnter 4 for YAML \n ";

    public static final String menuHelpers = "Select action: \nEnter 1 for Exit" +
            "\nEnter 2 for Help \nEnter 3 for Switch \n";


    public static final Scanner scanner = new Scanner(System.in);

    private static class PersonStorage {
    }

    private static PersonStorage personStorage;

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
        public static void main (String[]args){
            String s = null;
            showMenu();
        }
}