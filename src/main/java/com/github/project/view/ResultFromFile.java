package com.github.project.view;

import static com.github.project.utils.ReadingAndClearingData.readFile;

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
                    .replace("firstname:", "")
                    .replace("lastname:", "")
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
                    .replace("<firstname>", "")
                    .replace("</firstname>", "")
                    .replace("<lastname>", "")
                    .replace("</lastname>", "")
                    .replace("<age>", "")
                    .replace("</age>", "")
                    .replace("<city>", "")
                    .replace("</city>", "").replace("  ",
                            "").trim();
        } else if (file.endsWith(".csv")) {
            results = readFile(file).replace("id,firstname,lastname,age,city",
                    " ")
                    .replace(",", " ").replace("  ",
                            " ").trim();
        } else if (file.endsWith(".yaml")) {
            results = readFile(file).replace("-", "")
                    .replace(" ", "\n")
                    .replace("id", "")
                    .replace("firstname", "")
                    .replace("lastname", "")
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
