package com.company.view;

import com.company.persons.TransferToFormat;
import com.company.persons.Person;
import com.company.scanner.ScannerPers;
import com.company.StorageOfPersons;
import com.company.utils.FileUtil;
import com.company.utils.HelpersCommands;

import java.io.File;

import static com.company.view.MenuAndDaoTo.safeForFile;

public class Dialog {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;

    public static String crudMessages(String message){           //сюда позже залетим
        System.out.print(message);
                       String typeOfAction = scanner.next();
            return typeOfAction;

    }

    public static void crudMenu(String action, String fileName) {
        switch (action) {
            case "1": {
                System.out.print("Enter your firstName: ");
                String firstNameScan = scanner.next();

                System.out.print("Enter your lastName: ");
                String lastNameScan = scanner.next();

                System.out.print("Enter your age: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That not a number! Enter your age:");
                    scanner.next();
                }
                Integer ageScan = scanner.nextInt();


                System.out.print("Enter your city: ");
                String cityScan = scanner.next();

                if (fileName.endsWith(".json")) {
                    personStorage.getPersons().add(ScannerPers.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("js.json"), false, TransferToFormat.toJSON(personStorage));
                } else if (fileName.endsWith(".xml")) {
                    personStorage.getPersons().add(ScannerPers.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("xm.xml"), false, TransferToFormat.toXml(personStorage));
                } else if (fileName.endsWith(".csv")) {
                    personStorage.getPersons().add(ScannerPers.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("cv.csv"), false, TransferToFormat.toCsv(personStorage));
                } else if (fileName.endsWith(".yaml")) {
                    personStorage.getPersons().add(ScannerPers.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("ya.yaml"), false, TransferToFormat.toYaml(personStorage));
                }
                break;
            }
            case "2": {
                System.out.println(personStorage.getPersons());
                break;
            }
            case "3": {
                System.out.println("Enter Id for update");
                Integer id = scanner.nextInt();
                Person person = HelpersCommands.getById(id, personStorage);
                if (person == null) {
                    System.out.println("Person with this id doesn't exist");
                } else {
                    System.out.println(person);

                    System.out.print("Enter new firstName: ");
                    String firstNameScan = scanner.next();

                    System.out.print("Enter new lastName: ");
                    String lastNameScan = scanner.next();

                    System.out.print("Enter new age: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That not a number! Enter your age:");
                        scanner.next();
                    }
                    Integer ageScan = scanner.nextInt();

                    System.out.print("Enter new city: ");
                    String cityScan = scanner.next();

                    TransferToFormat.updatePerson(id, firstNameScan, lastNameScan, ageScan, cityScan, personStorage);

                    safeForFile(fileName);

                }
                break;
            }
            case "4": {
                System.out.println("Enter Id for delete");
                Integer id = scanner.nextInt();
                TransferToFormat.deleteById(id, personStorage);
                safeForFile(fileName);
                break;
            }
            default: {
                System.out.println("Wrong data");
            }
        }
    }
}
