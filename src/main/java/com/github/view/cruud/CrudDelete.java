package com.github.view.cruud;

import com.github.people.PersonData;
import com.github.view.daoformats.SearchAndDeletePersonById;
import com.github.view.daoformats.SearchObject;
import com.github.view.daoformats.formatssss.*;
import com.github.view.util.FileWrite;

import java.io.File;

public class CrudDelete {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static PersonData personStorage;

    public static void CrudDelete(String fileName){

        System.out.println("Enter Id for delete");
        while (!scanner.hasNextInt()) {
            System.out.println("That not a number! Enter number: ");
            scanner.next();
        }
        Integer id = scanner.nextInt();
        personStorage = new PersonData(SearchObject.getAllObjects(fileName));
        SearchAndDeletePersonById.deleteById(id, personStorage);
        safeForFile(fileName);
        System.out.println("Id deleted ");
        System.out.println();
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
