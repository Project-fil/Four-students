package com.github.view.daoformats;

import com.github.persons.Peoples;
import java.util.ArrayList;
import java.util.List;
import static com.github.view.formatsview.ResultFromFile.getResultFromFile;

public class SearchObject {
    public static List<Peoples> getAllObjects(String file) {
        String results = getResultFromFile(file);
        List<Peoples> persons = new ArrayList<>();
        if (!results.equals("")) {
            String[] arr = results.split(" ");
            for (int i = 0; i < arr.length; i = i + 5) {
                persons.add(new Peoples(Integer.parseInt(arr[i]),
                        arr[i + 1], arr[i + 2], Integer.parseInt(arr[i + 3]),
                        arr[i + 4]));
            }
        }
        return persons;
    }
}
