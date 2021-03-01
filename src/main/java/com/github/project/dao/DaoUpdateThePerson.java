package com.github.project.dao;

import com.github.project.people.People;
import com.github.project.people.personStorage;
import com.github.project.checks.IdChecks;
import com.github.project.utils.SearchObject;
import com.github.project.daoformats.UpdatePerson;
import com.github.project.daoformats.formats.*;
import com.github.project.view.WriteFileMethod;
import com.github.project.checks.SwitchCommand;
import java.io.File;

public class DaoUpdateThePerson {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static com.github.project.people.personStorage personStorage;

    public static void crudUpdate(String fileName) {

        System.out.println("Enter Id for update");
        while (!scanner.hasNextInt()) {
            System.out.println("That not a number! Enter number: ");
            scanner.next();
        }
        Integer id = scanner.nextInt();
        personStorage = new personStorage(SearchObject.getAllObjects(fileName));
        People person = IdChecks.getByIdForUpdate(id, personStorage);
        if (person == null) {
            System.out.println("Person with this id doesn't exist");
        } else {
            System.out.println(person);
            System.out.print("Enter new firs name: ");
            String firstNameScan = scanner.next();
            SwitchCommand.switchToMenuCheck(firstNameScan);
            System.out.print("Enter new last name: ");
            String lastNameScan = scanner.next();
            SwitchCommand.switchToMenuCheck(lastNameScan);
            System.out.print("Enter new age: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That not a number! Enter number: ");
                scanner.next();
            }
            Integer ageScan = scanner.nextInt();
            System.out.print("Enter new city: ");
            String cityScan = scanner.next();
            SwitchCommand.switchToMenuCheck(cityScan);
            UpdatePerson.updatePerson(id, firstNameScan, lastNameScan, ageScan, cityScan, personStorage);
            safeForFile(fileName);
            System.out.println("File updated ");
            System.out.println();
        }
    }
    public static void safeForFile(String fileName) {
        if (fileName.endsWith(".json")) {
            WriteFileMethod.writeFile(new File("js.json"), false, FormatJson.toJSON(personStorage));
        } else if (fileName.endsWith(".xml")) {
            WriteFileMethod.writeFile(new File("xm.xml"), false, FormatXml.toXml(personStorage));
        } else if (fileName.endsWith(".csv")) {
            WriteFileMethod.writeFile(new File("cv.csv"), false, FormatCsv.toCsv(personStorage));
        } else if (fileName.endsWith(".yaml")) {
            WriteFileMethod.writeFile(new File("ya.yaml"), false, FormatYaml.toYaml(personStorage));
        } else if (fileName.endsWith(".bin")) {
            WriteFileMethod.writeFile(new File("binary.bin"), false, FormatBinary.toBinaryFile(personStorage));
        }
    }
}
