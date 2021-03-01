package com.github.project.dao;

import com.github.project.people.PersonData;

import com.github.project.daoformats.formats.*;
import com.github.project.view.WriteFileMethod;
import com.github.project.checks.SwitchCommand;
import com.github.project.utils.FileChecksAndCreator;
import com.github.project.utils.IdCreator;

import java.io.File;

public class DaoFormats {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static PersonData personStorage;

    public static void crudFormats(String fileName){
        System.out.print("Enter first name: ");
        String firstNameScan = scanner.next();
        SwitchCommand.switchToMenuCheck(firstNameScan);
        System.out.print("Enter last name: ");
        String lastNameScan = scanner.next();
        SwitchCommand.switchToMenuCheck(lastNameScan);
        System.out.print("Enter age: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That not a number! Enter your age:");
            scanner.next();
        }
        Integer ageScan = scanner.nextInt();
        System.out.print("Enter your city: ");
        String cityScan = scanner.next();
        SwitchCommand.switchToMenuCheck(cityScan);
        personStorage = FileChecksAndCreator.createFileByFormat(fileName);
        if (fileName.endsWith(".json")) {
            personStorage.getPersons().add(IdCreator.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            WriteFileMethod.writeFile(new File("js.json"), false, FormatJson.toJSON(personStorage));
        } else if (fileName.endsWith(".xml")) {
            personStorage.getPersons().add(IdCreator.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            WriteFileMethod.writeFile(new File("xm.xml"), false, FormatXml.toXml(personStorage));
        } else if (fileName.endsWith(".csv")) {
            personStorage.getPersons().add(IdCreator.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            WriteFileMethod.writeFile(new File("cv.csv"), false, FormatCsv.toCsv(personStorage));
        } else if (fileName.endsWith(".yaml")) {
            personStorage.getPersons().add(IdCreator.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            WriteFileMethod.writeFile(new File("ya.yaml"), false, FormatYaml.toYaml(personStorage));
        } else if (fileName.endsWith(".bin")) {
            personStorage.getPersons().add(IdCreator.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
            WriteFileMethod.writeFile(new File("binary.bin"), false, FormatBinary.toBinary(personStorage));
        }
    }
}
