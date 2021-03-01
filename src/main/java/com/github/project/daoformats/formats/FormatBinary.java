package com.github.project.daoformats.formats;

import com.github.project.people.People;
import com.github.project.people.PersonData;

import java.io.*;
import java.util.List;

public class FormatBinary {

    public static String toBinary(PersonData personStorage) {
        List<People> personList = personStorage.getPersons();
        File file = new File("binary.bin");
        StringBuffer sb = null;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(personList);
            os.close();
            System.out.println("done writing");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream os = null;
//        try {
//            os = new ObjectOutputStream(bos);
//            os.writeObject(personList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] bytes = bos.toByteArray();
//        return Arrays.toString(bytes);
    }

