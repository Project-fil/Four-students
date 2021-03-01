package com.github.project.view.menu;

import static com.github.project.dao.DaoMenu.showMenu;

public class HelperMenu {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void helpersMethot(String action) {
        switch (action) {
            case "1": {
                System.out.println("Help: \n");
                System.out.println("In the main menu, select CRUD (enter '1')  to set the data about the person\n" +
                        "The data is accepted in the following order: id, name, surname, age(in numbers), city\n" +
                        "If you select '2' in the main menu, you will be taken to the Helper\n" +
                        "When you select '1' in the Helper menu, you turn on the Help (you are now here), to go to the main menu, enter '2'\n" +
                        "You can Switch to the main menu by selecting 'switch' from anywhere\n" +
                        "The program is turned off from the Helper menu to Exit the menu (enter '3') \n\n write '1' for close this menu ");

                while (true) {
                    String scanClose = scanner.next();
                    if (scanClose.equals("1")) {
                     showMenu();
                    } else {
                        System.out.println("Unknown command. Try again!");
                        continue;
                    }
                    break;
                }
            }
            case "2": {
                System.out.println("Switch \n");
                showMenu();
                break;
            }
            case "3": {
                while (true) {
                    System.out.println("Do you want Exit:\nEnter for 1 back to menu " +
                            "\nEnter for 2 Exit \n");
                    String scanExit = scanner.next();
                    if (scanExit.equals("1")) {
                        showMenu();
                    } else if (scanExit.equals("2")) {
                        System.out.println("Exit ");
                        System.exit(0);
                    } else {
                        System.out.println("Unknown command. Try again!");
                        continue;
                    }
                }
            }
            default:
                    throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}
