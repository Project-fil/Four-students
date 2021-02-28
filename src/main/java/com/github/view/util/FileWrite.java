package com.github.view.util;

import java.io.*;


public class FileWrite {

    public static void writeFile(File file, boolean arg, String sb) {
        try (FileWriter writer = new FileWriter(file, arg)) {
            writer.write(sb);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
