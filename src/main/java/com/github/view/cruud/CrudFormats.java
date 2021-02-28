package com.github.view.cruud;

import com.github.people.PersonData;
import com.github.view.util.NumberId;
import com.github.view.daoformats.formatssss.*;
import com.github.view.util.FileWrite;
import com.github.view.util.Switch;

import java.io.File;



public class CrudFormats {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static PersonData personStorage;

    public static void crudFormats(String fileName){
        System.out.print("Enter first name: ");
        String firstNameScan = scanner.next();
        Switch.switchToMenuCheck(firstNameScan);
        System.out.print("Enter last name: ");
        String lastNameScan = scanner.next();
        Switch.switchToMenuCheck(lastNameScan);
        System.out.print("Enter age: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That not a number! Enter your age:");
            scanner.next();
        }
        Integer ageScan = scanner.nextInt();
        System.out.print("Enter your city: ");
        String cityScan = scanner.next();
        Switch.switchToMenuCheck(cityScan);
        personStorage = FileOperations.createFileByFormat(fileName);
        if (fileName.endsWith(".json")) {
            personStorage.getPersons().add(NumberId.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            FileWrite.writeFile(new File("js.json"), false, FormatJson.toJSON(personStorage));
        } else if (fileName.endsWith(".xml")) {
            personStorage.getPersons().add(NumberId.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            FileWrite.writeFile(new File("xm.xml"), false, FormatXml.toXml(personStorage));
        } else if (fileName.endsWith(".csv")) {
            personStorage.getPersons().add(NumberId.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            FileWrite.writeFile(new File("cv.csv"), false, FormasCsv.toCsv(personStorage));
        } else if (fileName.endsWith(".yaml")) {
            personStorage.getPersons().add(NumberId.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            FileWrite.writeFile(new File("ya.yaml"), false, FormatYaml.toYaml(personStorage));
        } else if (fileName.endsWith(".bin")) {
            personStorage.getPersons().add(NumberId.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            FileWrite.writeFile(new File("binary.bin"), false, FormatBinary.toBinary(personStorage));
        }
    }
}
