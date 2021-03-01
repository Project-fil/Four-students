package com.github.view.cruud;

import com.github.people.PersonData;
import com.github.view.daoformats.SearchObject;

import static com.github.menu.Menu.showMenu;

public class CrudDialog {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void crudMenu(String action, String fileName) {
        switch (action) {
            case "1": {
               CrudFormats.crudFormats(fileName);
                break;
            }
            case "2": {
                System.out.println(new PersonData(SearchObject.getAllObjects(fileName)).getPersons());
                System.out.println();
                break;
            }
            case "3": {
               CrudUpdate.crudUpdate(fileName);
                break;
            }
            case "4": {
               CrudDelete.CrudDelete(fileName);
                break;
            }
            case "5": {
         showMenu();
                break;
            }
            default: {
                System.out.println("Wrong data");
            }
        }
    }


}
