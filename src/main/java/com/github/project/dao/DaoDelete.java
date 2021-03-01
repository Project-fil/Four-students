package com.github.project.dao;

import com.github.project.people.personStorage;
import com.github.project.utils.SearchAndDeletePersonById;
import com.github.project.utils.SearchObject;
import com.github.project.daoformats.formats.*;
import com.github.project.view.WriteFileMethod;

import java.io.File;

public class DaoDelete {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static com.github.project.people.personStorage personStorage;

    public static void CrudDelete(String fileName) {

        System.out.println("Enter Id for delete");
        while (!scanner.hasNextInt()) {
            System.out.println("That not a number! Enter number: ");
            scanner.next();
        }
        Integer id = scanner.nextInt();
        personStorage = new personStorage(SearchObject.getAllObjects(fileName));
        SearchAndDeletePersonById.deleteById(id, personStorage);
        safeForFile(fileName);
        System.out.println("Id deleted ");
        System.out.println();
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
