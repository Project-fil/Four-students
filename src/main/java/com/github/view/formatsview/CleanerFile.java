package com.github.view.formatsview;

import java.io.*;
import java.util.Scanner;

public class CleanerFile {

    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            Scanner scan = new Scanner(fr);
            int i = 1;
            while (scan.hasNextLine()) {
                sb.append(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public static void writeFile(File file, boolean arg, String sb) {
        try (FileWriter writer = new FileWriter(file, arg)) {
            writer.write(sb);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static String getResultFromFile(String file) {
        String results = "";
        if (file.endsWith(".json")) {
            results = readFile(file).replace("[", "")
                    .replace("{", "")
                    .replace("\"", "")
                    .replace(",", "")
                    .replace("}", "")
                    .replace("id:", "")
                    .replace("firstName:", "")
                    .replace("lastName:", "")
                    .replace("age:", "")
                    .replace("city:", "")
                    .replace("]", "").replace("  ",
                            "").trim();
        } else if (file.endsWith(".xml")) {
            results = readFile(file).replace("<Persons>", "")
                    .replace("</Persons>", "")
                    .replace("<Person>", "")
                    .replace("</Person>", "")
                    .replace("<id>", "")
                    .replace("</id>", "")
                    .replace("<firstName>", "")
                    .replace("</firstName>", "")
                    .replace("<lastName>", "")
                    .replace("</lastName>", "")
                    .replace("<age>", "")
                    .replace("</age>", "")
                    .replace("<city>", "")
                    .replace("</city>", "").replace("  ",
                            "").trim();
        } else if (file.endsWith(".csv")) {
            results = readFile(file).replace("id,firstName,lastName,age,city",
                    " ")
                    .replace(",", " ").replace("  ",
                            " ").trim();
        } else if (file.endsWith(".yaml")) {
            results = readFile(file).replace("-", "")
                    .replace(" ", "\n")
                    .replace("id", "")
                    .replace("firstName", "")
                    .replace("lastName", "")
                    .replace("age", "")
                    .replace("city", "")
                    .replace("\"", "")
                    .replace(",", " ")
                    .replace(":", "")
                    .replace("\n", " ")
                    .replace("  ", " ")
                    .trim();
        }
        return results;
    }
}
