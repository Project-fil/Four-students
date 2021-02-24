package com.github.view.formatsview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filewrite {

    public static void writeFile(File file, boolean arg, String sb) {
        try (FileWriter writer = new FileWriter(file, arg)) {
            writer.write(sb);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
