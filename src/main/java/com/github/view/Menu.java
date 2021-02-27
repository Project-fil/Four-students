package com.github.view;

import com.github.persons.PersonsData;
import com.github.view.cruud.CrudDialog;
import static com.github.view.cruud.CrudDialog.safeForFile;

public class Menu {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static PersonsData personStorage;

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
                      System.out.println("incorrect input. Try again! :)");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error :) data is written to file");
                System.out.println(e.getMessage());
                safeForFile(menuChoise);
            }
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
