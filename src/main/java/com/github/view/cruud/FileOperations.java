package com.github.view.cruud;

import com.github.people.PersonData;
import com.github.view.daoformats.SearchObject;

import java.io.File;
import java.io.IOException;

public class FileOperations {

    public static PersonData createFileByFormat(String extension) {

            if (!new File(extension).isFile()) {
                File f = new File(extension);
                try {
                    if (f.createNewFile())
                        System.out.println("File created\n");
                    else
                        System.out.println("File already exists\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                return new PersonData(SearchObject.getAllObjects(extension));
    }
}
