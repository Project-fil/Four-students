package com.github.view.cruud;

import com.github.persons.GetBy;
import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import com.github.view.daoformats.SearchObject;
import com.github.view.daoformats.UpdatePerson;
import com.github.view.daoformats.formatssss.*;
import com.github.view.formatsview.CleanerFile;
import com.github.view.daoformats.SearchAndDeletePersonById;
import com.github.view.Scanner;

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
                        personStorage = new PersonsData(SearchObject.getAllObjects("js.json"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("js.json"), false, FormatJson.toJSON(personStorage));
                    } else if (fileName.endsWith(".xml")) {
                        if (!new File("xm.xml").isFile()) {
                            File f = new File("xm.xml");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(SearchObject.getAllObjects("xm.xml"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("xm.xml"), false, FormatXml.toXml(personStorage));
                    } else if (fileName.endsWith(".csv")) {
                        if (!new File("cv.csv").isFile()) {
                            File f = new File("cv.csv");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(SearchObject.getAllObjects("cv.csv"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("cv.csv"), false, FormasCsv.toCsv(personStorage));
                    } else if (fileName.endsWith(".yaml")) {
                        if (!new File("ya.yaml").isFile()) {
                            File f = new File("ya.yaml");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(SearchObject.getAllObjects("ya.yaml"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("ya.yaml"), false, FormatYaml.toYaml(personStorage));
                    } else if (fileName.endsWith(".bin")) {
                        if (!new File("binary.bin").isFile()) {
                            File f = new File("binary.bin");
                            if (f.createNewFile())
                                System.out.println("File created");
                            else
                                System.out.println("File already exists");
                        }
                        personStorage = new PersonsData(SearchObject.getAllObjects("binary.bin"));
                        personStorage.getPersons().add(Scanner.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                        CleanerFile.writeFile(new File("binary.bin"), false, FormatBinary.toBinary(personStorage));
                    }
                    break;
                }
                    case "2": {

                    System.out.println(new PersonsData(SearchObject.getAllObjects(fileName)).getPersons());
                    break;
                }
                case "3": {
                    System.out.println("Enter Id for update");
                    Integer id = scanner.nextInt();
                    personStorage = new PersonsData(SearchObject.getAllObjects(fileName));
                    Peoples person = GetBy.getById(id, personStorage);
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
                        UpdatePerson.updatePerson(id, firstNameScan, lastNameScan, ageScan, cityScan, personStorage);
                        safeForFile(fileName);
                    }
                    break;
                }
                case "4": {
                    System.out.println("Enter Id for delete");
                    Integer id = scanner.nextInt();
                    SearchAndDeletePersonById.deleteById(id, personStorage);
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