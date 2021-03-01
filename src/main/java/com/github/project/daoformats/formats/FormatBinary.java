package com.github.project.daoformats.formats;

import com.github.project.people.People;
import com.github.project.people.personStorage;
import java.io.*;
import java.util.List;

public class FormatBinary {

    public static String toBinaryFile(personStorage personStorage){
        List<People> personList = personStorage.getPerson();
         File file = new File("binary.bin");
        StringBuffer sb = null;
        try (ObjectOutputStream os = new ObjectOutputStream(new  FileOutputStream((file)))) {
            os.writeObject(personList);
            os.close();
            System.out.println("done writing");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
