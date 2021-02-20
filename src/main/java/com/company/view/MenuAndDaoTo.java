package com.company.view;

import com.company.adnhz.Menu;
import com.company.persons.TransferToFormat;
import com.company.StorageOfPersons;
import com.company.utils.FileUtil;

import java.io.File;

public class MenuAndDaoTo {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;

    public static void showMenu() {
        boolean flagfor = true;
        while (flagfor) {
            System.out.println(Menu.menuCrudHelpers);
            String menuChoise = scanner.next();
            try {
                if (menuChoise.equals("1")) {
                    System.out.println(Menu.fileType);
                    String fileTypes = scanner.next();
                    System.out.println(Menu.menuCrud);
                    String crudChoose = scanner.next();
                    CrudDialog.crudMenu(crudChoose, fileTypes);
                }
                  if (menuChoise.equals("2")) {
                   System.out.println(Menu.menuHelpers);
                   String helpersChoose = scanner.next();
                   HelperMenu.helpersMethot(helpersChoose);
                }  else{
                    continue;
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
