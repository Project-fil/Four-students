import com.company.*;
import com.company.persons.TransferToFormat;
import com.company.persons.Person;
import com.company.utils.FileUtil;
import com.company.utils.HelpersCommands;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelperTest {

    private StorageOfPersons personStorage;
    private File file;

    @Before
    public void setUp() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person(1, "lolo",
                "wow", 20, "Kyiv");
        personList.add(person);
        personStorage = new StorageOfPersons(personList);
    }
    @Before
    public void setUp2() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person(1, "lolo",
                "wow", 20, "Kyiv");
        personList.add(person);
        personStorage = new StorageOfPersons(personList);
        FileUtil.writeFile(new File("jsTest2.json"), false, TransferToFormat.toJSON(personStorage));
    }

    @Test
    public void getByIdTest() {

        List<Person> expected = new ArrayList<>();

        expected.add(new Person(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        Person actual = HelpersCommands.getById(0, personStorage);
        assertEquals(expected.get(0), actual);
    }

    @Test
    public void getAllByCityTest() {

        List<Person> expected = new ArrayList<>();

        expected.add(new Person(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<Person> actual = HelpersCommands.getAllByCity("4", personStorage);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllByAgeTest() {

        List<Person> expected = new ArrayList<>();

        expected.add(new Person(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<Person> actual = HelpersCommands.getAllByAge(3, personStorage);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllByFirstNameTest() {

        List<Person> expected = new ArrayList<>();

        expected.add(new Person(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<Person> actual = HelpersCommands.getAllByFirstName("1", personStorage);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllByLastNameTest() {

        List<Person> expected = new ArrayList<>();

        expected.add(new Person(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<Person> actual = HelpersCommands.getAllByLastName("2", personStorage);
        assertEquals(expected, actual);

    }

    @Test
    public void deleteAllTest() {

        HelpersCommands.deleteAll(this.personStorage );
        assertEquals(this.personStorage.getPersons().size(), 0);

    }
}
