package test;

import com.github.project.daoformats.formats.FormatCsv;
import com.github.project.people.People;
import com.github.project.people.personStorage;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

class FormatCsvTest {
    private List<People> personList = new ArrayList<>();
    @Test
    public void toCvsTest() {

        personStorage personData = new personStorage(personList);
        String expected = "id,firstName,lastName,age,city \n" +
                "1,Dmytro,Poplavskiy,20,Kyiv \n";

        String result = FormatCsv.toCsv(personData);
        assertEquals(expected, result);
    }
}
