import com.company.Persons.Hui;
import com.company.Persons.PersonCreate;
import com.company.StorageOfPersons;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private List<PersonCreate> personList = new ArrayList<>();

    @Before
    public void setUp() {
        PersonCreate person = new PersonCreate(1, "lolo", "wow", 20, "Kyiv");
        personList.add(person);
    }

    @Test
    public void toJSONTest() {

        StorageOfPersons personStorage = new StorageOfPersons(personList);

        String expected = "[\n" +
                "{\n" +
                " \"id\":1,\n" +
                " \"firstName\":\"lol\",\n" +
                " \"lastName\":\"wow\",\n" +
                " \"age\":20,\n" +
                " \"city\":\"Kyiv\" \n" +
                " }\n" +
                "]";

        String result = Hui.toJSON(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void toXmlTest() {

        StorageOfPersons personStorage = new StorageOfPersons(personList);
        String expected = "<Persons>\n" +
                " <Person>\n" +
                " <id>1</id>\n" +
                " <firstName>lolo</firstName>\n" +
                " <lastName>wow</lastName>\n" +
                " <age>20</age>\n" +
                " <city>Kyiv</city>\n" +
                " </Person>\n" +
                "</Persons>\n";

        String result = Hui.toXml(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void toCvsTest() {

        StorageOfPersons personStorage = new StorageOfPersons(personList);
        String expected = "id,firstName,lastName,age,city \n" +
                "1,lolo,wow,20,Kyiv \n";

        String result = Hui.toCsv(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void toYamlTest() {

        StorageOfPersons personStorage = new StorageOfPersons(personList);
        String expected = "---\n" +
                "- \"id:1, firstName:lolo,lastName:wow,age:20,city:Kyiv\" \n";

        String result = Hui.toYaml(personStorage);
        assertEquals(expected, result);
    }

    @Test
    public void getAllObjectsTest() {

        List<PersonCreate> data = new ArrayList<>();
        data.add(new PersonCreate(0, "1", "2", 3, "4"));
        List<PersonCreate> actual = Hui.getAllObjects("./fileTest/jsTest.json");
        assertEquals(data, actual);
    }

    @Test
    public void updatePersonTest() {

        List<PersonCreate> expected = new ArrayList<>();
        expected.add(new PersonCreate(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        Hui.updatePerson(0, "3", "3", 3, "3", personStorage);

        List<PersonCreate> actual = new ArrayList<>();
        actual.add(new PersonCreate(0, "3", "3", 3, "3"));
        assertEquals(expected, actual);
    }

    @Test
    public void deleteByIdTest() {

        List<PersonCreate> expected = new ArrayList<>();
        expected.add(new PersonCreate(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        Hui.deleteById(0, personStorage);

        List<PersonCreate> actual = new ArrayList<>();
        assertEquals(personStorage.getPersons(), actual);
    }
}
