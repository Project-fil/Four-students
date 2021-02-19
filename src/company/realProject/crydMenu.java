package com.company.realProject;

import com.company.*;

import java.io.File;

class crudMenu {


   /* private static void crudMenu(String action, String fileName) {
        switch (action) {
            case "1": {
                System.out.print("Enter your firstName: ");
                String firstNameScan = scanner.next();

                System.out.print("Enter your lastName: ");
                String lastNameScan = scanner.next();

                System.out.print("Enter your age: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That not a number! Enter your age:");
                    scanner.next();
                }
                Integer ageScan = scanner.nextInt();


                System.out.print("Enter your city: ");
                String cityScan = scanner.next();

                if (fileName.endsWith(".json")) {
                    personStorage.getPersons().add(PersonBuilder.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("js.json"), false, Parser.toJSON(personStorage));
                } else if (fileName.endsWith(".xml")) {
                    personStorage.getPersons().add(PersonBuilder.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("xm.xml"), false, Parser.toXml(personStorage));
                } else if (fileName.endsWith(".csv")) {
                    personStorage.getPersons().add(PersonBuilder.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("cv.csv"), false, Parser.toCsv(personStorage));
                } else if (fileName.endsWith(".yaml")) {
                    personStorage.getPersons().add(PersonBuilder.createPerson(personStorage, firstNameScan, lastNameScan, ageScan, cityScan));
                    FileUtil.writeFile(new File("ya.yaml"), false, Parser.toYaml(personStorage));
                }
                break;
            }
            case "2": {
                System.out.println(personStorage.getPersons());
                break;
            }
            case "3": {
                System.out.println("Enter Id for update");
                Integer id = scanner.nextInt();
                Person person = Helper.getById(id, personStorage);
                if (person == null) {
                    System.out.println("Person with this id doesn't exist");
                } else {
                    System.out.println(person);

                    System.out.print("Enter new firstName: ");
                    String firstNameScan = scanner.next();

                    System.out.print("Enter new lastName: ");
                    String lastNameScan = scanner.next();

                    System.out.print("Enter new age: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That not a number! Enter your age:");
                        scanner.next();
                    }
                    Integer ageScan = scanner.nextInt();

                    System.out.print("Enter new city: ");
                    String cityScan = scanner.next();

                    Parser.updatePerson(id, firstNameScan, lastNameScan, ageScan, cityScan, personStorage);

                    safeForFile(fileName);

                }
                break;
            }
            case "4": {
                System.out.println("Enter Id for delete");
                Integer id = scanner.nextInt();
                Parser.deleteById(id, personStorage);
                safeForFile(fileName);
                break;
            }
            default: {
                System.out.println("Wrong data");
            }
        }
    }*/
}