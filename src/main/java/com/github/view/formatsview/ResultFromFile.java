package com.github.view.formatsview;

import static com.github.view.formatsview.CleanerFile.readFile;

public class ResultFromFile {

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

