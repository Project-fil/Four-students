package com.company.view;

import com.company.StorageOfPersons;
import com.company.utils.HelpersCommands;

import static com.company.view.MenuAndDaoTo.safeForFile;
import static com.company.view.MenuAndDaoTo.showMenu;

public class HelperMenu {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;
    public static void helpersMethot(String action) {

        switch (action) {
            case "1": {
                System.out.println("Help: \n");
               System.out.println("In the main menu, select CRUD (enter 1)  to set the data about the person\n" +
                       "The data is accepted in the following order: id, name, surname, age(in numbers), city\n" +
                       "If you select 2 in the main menu, you will be taken to the helper\n" +
                       "When you select 1 in the helper menu, you turn on the help (you are now here), to go to the main menu, enter 2\n" +
                       "From the helper menu, you can switch to the main menu by selecting switch (enter 2)\n" +
                       "The program is turned off from the helper menu to exit the menu (enter 3) \n write 1 for close this menu ");

               while(true){
                   String scanClose = scanner.next();
               if (scanClose.equals("1")) {
                   showMenu();
               }
               else {
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
                System.out.println("Exit ");
                System.exit(0);
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}
