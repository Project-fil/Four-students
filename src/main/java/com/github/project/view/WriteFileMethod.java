package com.github.project.view;

import java.io.*;

public class WriteFileMethod {

    public static void writeFile(File file, boolean arg, String sb) {
        try (FileWriter writer = new FileWriter(file, arg)) {
            writer.write(sb);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
