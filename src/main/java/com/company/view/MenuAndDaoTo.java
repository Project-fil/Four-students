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
            System.out.print("Select a file type: \nEnter 1 for JSON " +
                    "\nEnter 2 for XML \nEnter 3 for CSV " +
                    "\nEnter 4 for YAML \n ");
            System.out.println(Menu.menuCrudHelpers);
            String menuChoise = scanner.next();
            boolean flag = true;
            String ac = null;
            try {
                    if (menuChoise.equals("1")){
                        System.out.println(Menu.fileType);
                        String fileTypes = scanner.next();
                            System.out.println(Menu.menuCrud);

                            String crudChoose = scanner.next();
                                Dialog.crudMenu(crudChoose,fileTypes);
                            }
//                if (menuChoise.equals("1")) {
//                    if(!new File("js.json").isFile())
//                    {
//                        File f = new File("js.json");
//
//                        if (f.createNewFile())
//                            System.out.println("File created");
//                        else
//                            System.out.println("File already exists");
//                    }
//                    personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("js.json"));
//                    while (flag) {
//                        System.out.print("Select action: \nEnter 1 for CRUD " +
//                                "\nEnter 2 for HELPERS \n ");
//                        String typeOfAction = scanner.next();
//                        if (typeOfAction.equals("1")) {
//                            System.out.print("Select action: \nEnter 1 for Create " +
//                                    "\nEnter 2 for ReadAll \nEnter 3 for Update " +
//                                    "\nEnter 4 for Delete \n ");
//                            String action = scanner.next();
//                            Dialog.crudMenu(action, "js.json");
//                        } else if (typeOfAction.equals("2")) {
//                            System.out.print("Select action: \nEnter 1 for getById " +
//                                    "\nEnter 2 for getAllByCity " +
//                                    "\nEnter 3 for getAllByAge" +
//                                    "\nEnter 4 for getAllByFirstName " +
//                                    "\nEnter 5 for getAllByLastName " +
//                                    "\nEnter 6 for deleteAll \n ");
//                            String action = scanner.next();
//                            HelperMenu.personAdd(action, personStorage,
//                                    getFileNameByTypeOfFile(menuChoise));
//                        }
//                        System.out.println("Enter 1 for continue or 2 for exit");
//                        ac = new java.util.Scanner(System.in).next();
//                        if (ac.equals("2")) {
//                            flag = false;
//                        }
//                    }
//                } else if (menuChoise.equals("2")) {
//
//                    if(!new File("xm.xml").isFile())
//                    {
//                        File f = new File("xm.xml");
//
//                        if (f.createNewFile())
//                            System.out.println("File created");
//                        else
//                            System.out.println("File already exists");
//                    }
//                    personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("xm.xml"));
//                    while (flag) {
//                        System.out.print("Select action: \nEnter 1 for CRUD " +
//                                "\nEnter 2 for HELPERS \n ");
//                        String typeOfAction = scanner.next();
//                        if (typeOfAction.equals("1")) {
//                            System.out.print("Select action: \nEnter 1 for Create " +
//                                    "\nEnter 2 for ReadAll \nEnter 3 for Update " +
//                                    "\nEnter 4 for Delete \n ");
//                            String action = scanner.next();
//                            Dialog.crudMenu(action, "xm.xml");
//                        } else if (typeOfAction.equals("2")) {
//                            System.out.print("Select action: \nEnter 1 for getById " +
//                                    "\nEnter 2 for getAllByCity " +
//                                    "\nEnter 3 for getAllByAge" +
//                                    "\nEnter 4 for getAllByFirstName " +
//                                    "\nEnter 5 for getAllByLastName " +
//                                    "\nEnter 6 for deleteAll \n ");
//                            String action = scanner.next();
//                            HelperMenu.personAdd(action, personStorage,
//                                    getFileNameByTypeOfFile(menuChoise));
//                        }
//                        System.out.println("Enter 1 for continue or 2 for exit");
//                        ac = new java.util.Scanner(System.in).next();
//                        if (ac.equals("2")) {
//                            flag = false;
//                        }
//                    }
//                } else if (menuChoise.equals("3")) {
//                    if(!new File("cv.csv").isFile())
//                    {
//                        File f = new File("cv.csv");
//                        if (f.createNewFile())
//                            System.out.println("File created");
//                        else
//                            System.out.println("File already exists");
//                    }
//                    personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("cv.csv"));
//                    while (flag) {
//                            String typeOfAction = Dialog.crudMessages("Select action: \nEnter 1 for CRUD " +
//                                    "\nEnter 2 for HELPERS \n ");
//                        if (typeOfAction.equals("1")) {
//                            System.out.print("Select action: \nEnter 1 for Create " +
//                                    "\nEnter 2 for ReadAll \nEnter 3 for Update " +
//                                    "\nEnter 4 for Delete \n ");
//                            String action = scanner.next();
//                            Dialog.crudMenu(action, "cv.csv");
//                        } else if (typeOfAction.equals("2")) {
//                            System.out.print("Select action: \nEnter 1 for getById " +
//                                    "\nEnter 2 for getAllByCity " +
//                                    "\nEnter 3 for getAllByAge" +
//                                    "\nEnter 4 for getAllByFirstName " +
//                                    "\nEnter 5 for getAllByLastName " +
//                                    "\nEnter 6 for deleteAll \n ");
//                            String action = scanner.next();
//                            HelperMenu.personAdd(action, personStorage,
//                                    getFileNameByTypeOfFile(menuChoise));
//                        }
//                        System.out.println("Enter 1 for continue or 2 for exit");
//                        ac = new java.util.Scanner(System.in).next();
//                        if (ac.equals("2")) {
//                            flag = false;
//                        }
//                    }
//                } else if (menuChoise.equals("4")) {
//
//                    if(!new File("ya.yaml").isFile())
//                    {
//                        File f = new File("ya.yaml");
//
//                        if (f.createNewFile())
//                            System.out.println("File created");
//                        else
//                            System.out.println("File already exists");
//                    }
//                    personStorage = new StorageOfPersons(TransferToFormat.getAllObjects("ya.yaml"));
//                    while (flag) {
//                        System.out.print("Select action: \nEnter 1 for CRUD " +
//                                "\nEnter 2 for HELPERS \n ");
//                        String typeOfAction = scanner.next();
//                        if (typeOfAction.equals("1")) {
//                            System.out.print("Select action: \nEnter 1 for Create " +
//                                    "\nEnter 2 for ReadAll \nEnter 3 for Update " +
//                                    "\nEnter 4 for Delete \n ");
//                            String action = scanner.next();
//                            Dialog.crudMenu(action, "ya.yaml");
//                        } else if (typeOfAction.equals("2")) {
//                            System.out.print("Select action: \nEnter 1 for getById " +
//                                    "\nEnter 2 for getAllByCity " +
//                                    "\nEnter 3 for getAllByAge" +
//                                    "\nEnter 4 for getAllByFirstName " +
//                                    "\nEnter 5 for getAllByLastName " +
//                                    "\nEnter 6 for deleteAll \n ");
//                            String action = scanner.next();
//                            HelperMenu.personAdd(action, personStorage,
//                                    getFileNameByTypeOfFile(menuChoise));
//                        }
//                        System.out.println("Enter 1 for continue or 2 for exit");
//                        ac = new java.util.Scanner(System.in).next();
//                        if (ac.equals("2")) {
//                            flag = false;
//                        }
//                    }
                } else {
                    continue;
                }
                if (ac.equals("2")) {
                    flagfor = false;
                    safeForFile(menuChoise);
                }
            } catch (Exception e) {
                System.out.println("Error) data is written to file");
                safeForFile(typeOfFile);
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
