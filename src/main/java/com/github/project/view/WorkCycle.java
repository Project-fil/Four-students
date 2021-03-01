package com.github.project.view;

import com.github.project.dao.DaoDelete;
import com.github.project.dao.DaoFormats;
import com.github.project.dao.DaoUpdateThePerson;
import com.github.project.people.PersonData;
import com.github.project.utils.SearchObject;

import static com.github.project.dao.DaoMenu.showMenu;

public class WorkCycle {

    public static void crudMenu(String action, String fileName) {
        switch (action) {
            case "1": {
               DaoFormats.crudFormats(fileName);
                break;
            }
            case "2": {
                System.out.println(new PersonData(SearchObject.getAllObjects(fileName)).getPersons());
                System.out.println();
                break;
            }
            case "3": {
               DaoUpdateThePerson.crudUpdate(fileName);
                break;
            }
            case "4": {
               DaoDelete.CrudDelete(fileName);
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
