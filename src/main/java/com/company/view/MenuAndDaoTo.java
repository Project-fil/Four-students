package com.company.view;

import com.company.adnhz.Menu;
import com.company.persons.TransferToFormat;
import com.company.StorageOfPersons;
import com.company.utils.FileUtil;

import java.io.File;

public class MenuAndDaoTo {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;

    public static void showMenu() {         //create
        boolean flagfor = true;
        while (flagfor) {
            System.out.println(Menu.menuCrudHelpers);
            String menuChoise = scanner.next();
            boolean flag = true;
            String ac = null;
            try {
                if (menuChoise.equals("1")) {
                    System.out.println(Menu.fileType);
                    System.out.println();
                    String fileTypes = scanner.next();
                    System.out.println(Menu.menuCrud);
                    String crudChoose = scanner.next();
                    CrudDialog.crudMenu(crudChoose, fileTypes);
                }
                if (menuChoise.equals("1")) {
                    if (!new File("js.json").isFile()) {
                        File f = new File("js.json");

                        if (f.createNewFile())
                            System.out.println("File created");
                        else
                            System.out.println("File already exists");
                    }

                    personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("js.json"));
                } else {
                    continue;
                }
                if (ac.equals("2")) {
                    flagfor = false;
                    safeForFile(menuChoise);
                }
            } catch (Exception e) {
                System.out.println("Error) data is written to file");
                safeForFile(menuChoise);
            }
        }
    }

    public static String getFileNameByTypeOfFile(String typeOfFile) {
        if (typeOfFile.equals("1")) {
            return "js.json";
        } else if (typeOfFile.equals("2")) {
            return "xm.xml";
        } else if (typeOfFile.equals("3")) {
            return "cv.csv";
        } else if (typeOfFile.equals("4")) {
            return "ya.yaml";
        }
        return "";
    }

    public static void safeForFile(String fileName) {
        if (fileName.endsWith(".json")) {
            FileUtil.writeFile(new File("js.json"), false, TransferToFormat.toJSON(personStorage));
        } else if (fileName.endsWith(".xml")) {
            FileUtil.writeFile(new File("xm.xml"), false, TransferToFormat.toXml(personStorage));
        } else if (fileName.endsWith(".csv")) {
            FileUtil.writeFile(new File("cv.csv"), false, TransferToFormat.toCsv(personStorage));
        } else if (fileName.endsWith(".yaml")) {
            FileUtil.writeFile(new File("ya.yaml"), false, TransferToFormat.toYaml(personStorage));
        }
    }
}
