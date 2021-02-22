package com.github.view;

import com.github.persons.GetBy;
import com.github.persons.Person;
import com.github.persons.PersonsData;
import com.github.persons.CleanerFile;

import java.io.File;
import java.io.IOException;

import static com.github.view.Menu.safeForFile;

public class CrudDialog {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static PersonsData personStorage;

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
                        personStorage = new PersonsData(CrudFormats.getAllObjects("js.json"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("js.json"), false, CrudFormats.toJSON(personStorage));
                    } else if (fileName.endsWith(".xml")) {
                        if (!new File("xm.xml").isFile()) {
                            File f = new File("xm.xml");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(CrudFormats.getAllObjects("xm.xml"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("xm.xml"), false, CrudFormats.toXml(personStorage));
                    } else if (fileName.endsWith(".csv")) {
                        if (!new File("cv.csv").isFile()) {
                            File f = new File("cv.csv");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(CrudFormats.getAllObjects("cv.csv"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("cv.csv"), false, CrudFormats.toCsv(personStorage));
                    } else if (fileName.endsWith(".yaml")) {
                        if (!new File("ya.yaml").isFile()) {
                            File f = new File("ya.yaml");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(CrudFormats.getAllObjects("ya.yaml"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("ya.yaml"), false, CrudFormats.toYaml(personStorage));
                    } else if (fileName.endsWith(".bin")) {
                        if (!new File("binary.bin").isFile()) {
                            File f = new File("binary.bin");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(CrudFormats.getAllObjects("binary.bin"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("binary.bin"), false, CrudFormats.toBinary(personStorage));
                    }
                    break;
                }
                    case "2": {

                    System.out.println(new PersonsData(CrudFormats.getAllObjects(fileName)).getPersons());
                    break;
                }
                case "3": {
                    System.out.println("Enter Id for update");
                    Integer id = scanner.nextInt();
                    personStorage = new PersonsData(CrudFormats.getAllObjects(fileName));
                    Person person = GetBy.getById(id, personStorage);
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
                        CrudFormats.updatePerson(id, firstNameScan, lastNameScan, ageScan, cityScan, personStorage);
                        safeForFile(fileName);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Enter Id for delete");
                    Integer id = scanner.nextInt();
                    CrudFormats.deleteById(id, personStorage);
                    safeForFile(fileName);
                    break;
                }
                default: {
                    System.out.println("Wrong data");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
