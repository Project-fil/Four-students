package com.company.view;

import com.company.adnhz.ShowMenu;
import com.company.persons.TransferToFormat;
import com.company.StorageOfPersons;
import com.company.utils.FileUtil;

import java.io.File;
import java.io.IOException;

public class MenuAndDaoTo {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static StorageOfPersons personStorage;

    public static void showMenu() {
        boolean flagfor = true;
        while (flagfor) {
            System.out.println(ShowMenu.menuCrudHelpers);
            String menuChoise = scanner.next();
            try {
                if (menuChoise.equals("1")) {
                    System.out.println(ShowMenu.fileType);
                    String fileTypes = scanner.next();
                    System.out.println(ShowMenu.menuCrud);
                    String crudChoose = scanner.next();
                    CrudDialog.crudMenu(crudChoose, getFileNameByTypeOfFile(fileTypes));
                }
                  if (menuChoise.equals("2")) {
                   System.out.println(ShowMenu.menuHelpers);
                   String helpersChoose = scanner.next();
                   HelperMenu.helpersMethot(helpersChoose);
                }  else{
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error) data is written to file");
                System.out.println(e.getMessage());
                safeForFile(menuChoise);
            }
        }
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
        else if (fileName.endsWith(".bin")) {
            FileUtil.writeFile(new File("binary.bin"), false, TransferToFormat.toBinary(personStorage));
        }
    }
    private static String getFileNameByTypeOfFile(String typeOfFile) {
        if (typeOfFile.equals("1")) {
            return "js.json";
        } else if (typeOfFile.equals("2")) {
            return "xm.xml";
        } else if (typeOfFile.equals("3")) {
            return "cv.csv";
        } else if (typeOfFile.equals("4")) {
            return "ya.yaml";
        } else if (typeOfFile.equals("5")) {
            return "binary.bin";
        }
        return "";
    }

}
