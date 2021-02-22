import com.github.view.formats.CrudFormats;
import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private List<Peoples> personList = new ArrayList<>();

    @Before
    public void setUp() {
        Peoples person = new Peoples(1, "lolo", "wow", 20, "Kyiv");
        personList.add(person);
    }

    @Test
    public void toJSONTest() {

        PersonsData personStorage = new PersonsData(personList);

        String expected = "[\n" +
                "{\n" +
                " \"id\":1,\n" +
                " \"firstName\":\"lol\",\n" +
                " \"lastName\":\"wow\",\n" +
                " \"age\":20,\n" +
                " \"city\":\"Kyiv\" \n" +
                " }\n" +
                "]";

        String result = CrudFormats.toJSON(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void toXmlTest() {

        PersonsData personStorage = new PersonsData(personList);
        String expected = "<Persons>\n" +
                " <Person>\n" +
                " <id>1</id>\n" +
                " <firstName>lolo</firstName>\n" +
                " <lastName>wow</lastName>\n" +
                " <age>20</age>\n" +
                " <city>Kyiv</city>\n" +
                " </Person>\n" +
                "</Persons>\n";

        String result = CrudFormats.toXml(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void toCvsTest() {

        PersonsData personStorage = new PersonsData(personList);
        String expected = "id,firstName,lastName,age,city \n" +
                "1,lolo,wow,20,Kyiv \n";

        String result = CrudFormats.toCsv(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void toYamlTest() {

        PersonsData personStorage = new PersonsData(personList);
        String expected = "---\n" +
                "- \"id:1, firstName:lolo,lastName:wow,age:20,city:Kyiv\" \n";

        String result = CrudFormats.toYaml(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void getAllObjectsTest() {

        List<Peoples> data = new ArrayList<>();
        data.add(new Peoples(0, "1", "2", 3, "4"));
        List<Peoples> actual = CrudFormats.getAllObjects("./fileTest/jsTest.json");
        assertEquals(data, actual);
    }

    @Test
    public void updatePersonTest() {

        List<Peoples> expected = new ArrayList<>();
        expected.add(new Peoples(0, "1", "2", 3, "4"));
        PersonsData personStorage = new PersonsData(expected);
        CrudFormats.updatePerson(0, "3", "3", 3, "3", personStorage);

        List<Peoples> actual = new ArrayList<>();
        actual.add(new Peoples(0, "3", "3", 3, "3"));
        assertEquals(expected, actual);
    }

    @Test
    public void deleteByIdTest() {

        List<Peoples> expected = new ArrayList<>();
        expected.add(new Peoples(0, "1", "2", 3, "4"));
        PersonsData personStorage = new PersonsData(expected);
        CrudFormats.deleteById(0, personStorage);

        List<Peoples> actual = new ArrayList<>();
        assertEquals(personStorage.getPersons(), actual);
    }
}
