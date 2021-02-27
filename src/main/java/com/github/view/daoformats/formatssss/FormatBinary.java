package com.github.view.daoformats.formatssss;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FormatBinary {

    public static String toBinary(PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
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

