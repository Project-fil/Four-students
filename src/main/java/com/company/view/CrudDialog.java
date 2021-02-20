package com.company.view;

import com.company.persons.TransferToFormat;
import com.company.persons.Person;
import com.company.scanner.ScannerPers;
import com.company.StorageOfPersons;
import com.company.utils.FileUtil;
import com.company.utils.HelpersCommands;

import java.io.File;

import static com.company.view.MenuAndDaoTo.safeForFile;

public class CrudDialog {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;

    public static void crudMenu(String action, String fileName) {
        try {
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
                        if (!new File("js.json").isFile()) {
                            File f = new File("js.json");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("js.json"));
                        personStorage.getPersons().add(ScannerPers.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        FileUtil.writeFile(new File("js.json"), false, TransferToFormat.toJSON(personStorage));
                    } else if (fileName.endsWith(".xml")) {
                        if (!new File("xm.xml").isFile()) {
                            File f = new File("xm.xml");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("xm.xml"));
                        personStorage.getPersons().add(ScannerPers.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        FileUtil.writeFile(new File("xm.xml"), false, TransferToFormat.toXml(personStorage));
                    } else if (fileName.endsWith(".csv")) {
                        if (!new File("cv.csv").isFile()) {
                            File f = new File("cv.csv");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("cv.csv"));
                        personStorage.getPersons().add(ScannerPers.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        FileUtil.writeFile(new File("cv.csv"), false, TransferToFormat.toCsv(personStorage));
                    } else if (fileName.endsWith(".yaml")) {
                        if (!new File("ya.yaml").isFile()) {
                            File f = new File("ya.yaml");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("ya.yaml"));
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
