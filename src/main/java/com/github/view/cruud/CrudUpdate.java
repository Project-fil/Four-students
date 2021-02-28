package com.github.view.cruud;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import com.github.persons.SearchID;
import com.github.view.daoformats.SearchObject;
import com.github.view.daoformats.UpdatePerson;
import com.github.view.daoformats.formatssss.*;
import com.github.view.formatsview.FileWrite;
import com.github.view.formatsview.Switch;

import java.io.File;

import static com.github.view.cruud.CrudDelete.safeForFile;

public class CrudUpdate {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static PersonsData personStorage;

    public static void crudUpdate(String fileName) {

        System.out.println("Enter Id for update");
        while (!scanner.hasNextInt()) {
            System.out.println("That not a number! Enter number: ");
            scanner.next();
        }
        Integer id = scanner.nextInt();
        personStorage = new PersonsData(SearchObject.getAllObjects(fileName));
        Peoples person = SearchID.getByIdForUpdate(id, personStorage);
        if (person == null) {
            System.out.println("Person with this id doesn't exist");
        } else {
            System.out.println(person);
            System.out.print("Enter new firs name: ");
            String firstNameScan = scanner.next();
            Switch.switchToMenuCheck(firstNameScan);
            System.out.print("Enter new last name: ");
            String lastNameScan = scanner.next();
            Switch.switchToMenuCheck(lastNameScan);
            System.out.print("Enter new age: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That not a number! Enter number: ");
                scanner.next();
            }
            Integer ageScan = scanner.nextInt();
            System.out.print("Enter new city: ");
            String cityScan = scanner.next();
            Switch.switchToMenuCheck(cityScan);
            UpdatePerson.updatePerson(id, firstNameScan, lastNameScan, ageScan, cityScan, personStorage);
            safeForFile(fileName);
            System.out.println("File updated ");
            System.out.println();
        }
    }

    public static void safeForFile(String fileName) {
        if (fileName.endsWith(".json")) {
            FileWrite.writeFile(new File("js.json"), false, FormatJson.toJSON(personStorage));
        } else if (fileName.endsWith(".xml")) {
            FileWrite.writeFile(new File("xm.xml"), false, FormatXml.toXml(personStorage));
        } else if (fileName.endsWith(".csv")) {
            FileWrite.writeFile(new File("cv.csv"), false, FormasCsv.toCsv(personStorage));
        } else if (fileName.endsWith(".yaml")) {
            FileWrite.writeFile(new File("ya.yaml"), false, FormatYaml.toYaml(personStorage));
        } else if (fileName.endsWith(".bin")) {
            FileWrite.writeFile(new File("binary.bin"), false, FormatBinary.toBinary(personStorage));
        }
    }
}
