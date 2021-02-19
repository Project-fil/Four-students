package com.company.Dao;

import com.company.StorageOfPersons;
import com.company.Utils.Helper;

import static com.company.Dao.MenuAndDaoTo.safeForFile;

public class Helper123 {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;

    public static void helperMenu(String action, StorageOfPersons personStorage,
                                  String fileName) {
        switch (action) {
            case "1": {
                System.out.println("Enter Id ");
                Integer idHelpers = scanner.nextInt();
                System.out.println(Helper.getById(idHelpers, personStorage));
                break;
            }
            case "2": {
                System.out.println("Enter City ");
                String cityHelpers = scanner.next();
                System.out.println(Helper.getAllByCity(cityHelpers, personStorage));
                break;
            }
            case "3": {
                System.out.println("Enter Age ");
                Integer ageHelpers = scanner.nextInt();
                System.out.println(Helper.getAllByAge(ageHelpers, personStorage));
                break;
            }
            case "4": {
                System.out.println("Enter FirstName ");
                String firstNameHelpers = scanner.next();
                System.out.println(Helper.getAllByFirstName(firstNameHelpers, personStorage));
                break;
            }

            case "5": {
                System.out.println("Enter LastName ");
                String secondHelpers = scanner.next();
                System.out.println(Helper.getAllByLastName(secondHelpers, personStorage));
                break;
            }
            case "6": {
                Helper.deleteAll(personStorage);
                safeForFile(fileName);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }
}
