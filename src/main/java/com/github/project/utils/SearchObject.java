package com.github.project.utils;

import com.github.project.people.People;

import java.util.ArrayList;
import java.util.List;

import static com.github.project.view.ResultFromFile.getResultFromFile;

public class SearchObject {
    public static List<People> getAllObjects(String file) {
        String results = getResultFromFile(file);
        List<People> persons = new ArrayList<>();
        if (!results.equals("")) {
            String[] arr = results.split(" ");
            for (int i = 0; i < arr.length; i = i + 5) {
                persons.add(new People(Integer.parseInt(arr[i]),
                        arr[i + 1], arr[i + 2], Integer.parseInt(arr[i + 3]),
                        arr[i + 4]));
            }
        }
        return persons;
    }
}
