package com.github.project.utils;

import com.github.project.people.personStorage;

import java.io.File;
import java.io.IOException;

public class FileChecksAndCreator {

    public static personStorage createFileByFormat(String extension) {

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
                return new personStorage(SearchObject.getAllObjects(extension));
    }
}
