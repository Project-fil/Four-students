package com.company.view;

import com.company.StorageOfPersons;
import com.company.utils.HelpersCommands;

import static com.company.view.MenuAndDaoTo.safeForFile;

public class HelperMenu {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;

    public static void personAdd(String action, StorageOfPersons personStorage,
                                 String fileName) {
        switch (action) {
            case "1": {
                System.out.println("Enter Id ");
                Integer idHelpers = scanner.nextInt();
                System.out.println(HelpersCommands.getById(idHelpers, personStorage));
                break;
            }
            case "2": {
                System.out.println("Enter City ");
                String cityHelpers = scanner.next();
                System.out.println(HelpersCommands.getAllByCity(cityHelpers, personStorage));
                break;
            }
            case "3": {
                System.out.println("Enter Age ");
                Integer ageHelpers = scanner.nextInt();
                System.out.println(HelpersCommands.getAllByAge(ageHelpers, personStorage));
                break;
            }
            case "4": {
                System.out.println("Enter FirstName ");
                String firstNameHelpers = scanner.next();
                System.out.println(HelpersCommands.getAllByFirstName(firstNameHelpers, personStorage));
                break;
            }

            case "5": {
                System.out.println("Enter LastName ");
                String secondHelpers = scanner.next();
                System.out.println(HelpersCommands.getAllByLastName(secondHelpers, personStorage));
                break;
            }
            case "6": {
                HelpersCommands.deleteAll(personStorage);
                safeForFile(fileName);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}
