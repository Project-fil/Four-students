package com.github.view.cruud;

import com.github.persons.SearchID;
import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import com.github.view.daoformats.SearchObject;
import com.github.view.daoformats.UpdatePerson;
import com.github.view.daoformats.formatssss.*;
import com.github.view.daoformats.SearchAndDeletePersonById;
import com.github.view.Scanner;
import com.github.view.formatsview.FileWrite;
import com.github.view.formatsview.Switch;

import java.io.File;

import static com.github.view.Menu.showMenu;

public class CrudDialog {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    static PersonsData personStorage;

    public static void crudMenu(String action, String fileName) {
        switch (action) {
            case "1": {
               CrudFormats.crudFormats(fileName);
                break;
            }
            case "2": {
                System.out.println(new PersonsData(SearchObject.getAllObjects(fileName)).getPersons());
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
