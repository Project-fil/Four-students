import com.company.*;
import com.company.Persons.Hui;
import com.company.Persons.PersonCreate;
import com.company.Utils.FileUtil;
import com.company.Utils.Helper;
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
        List<PersonCreate> personList = new ArrayList<>();
        PersonCreate person = new PersonCreate(1, "lolo",
                "wow", 20, "Kyiv");
        personList.add(person);
        personStorage = new StorageOfPersons(personList);
    }
    @Before
    public void setUp2() {
        List<PersonCreate> personList = new ArrayList<>();
        PersonCreate person = new PersonCreate(1, "lolo",
                "wow", 20, "Kyiv");
        personList.add(person);
        personStorage = new StorageOfPersons(personList);
        FileUtil.writeFile(new File("jsTest2.json"), false, Hui.toJSON(personStorage));
    }

    @Test
    public void getByIdTest() {

        List<PersonCreate> expected = new ArrayList<>();

        expected.add(new PersonCreate(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        PersonCreate actual = Helper.getById(0, personStorage);
        assertEquals(expected.get(0), actual);
    }

    @Test
    public void getAllByCityTest() {

        List<PersonCreate> expected = new ArrayList<>();

        expected.add(new PersonCreate(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<PersonCreate> actual = Helper.getAllByCity("4", personStorage);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllByAgeTest() {

        List<PersonCreate> expected = new ArrayList<>();

        expected.add(new PersonCreate(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<PersonCreate> actual = Helper.getAllByAge(3, personStorage);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllByFirstNameTest() {

        List<PersonCreate> expected = new ArrayList<>();

        expected.add(new PersonCreate(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<PersonCreate> actual = Helper.getAllByFirstName("1", personStorage);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllByLastNameTest() {

        List<PersonCreate> expected = new ArrayList<>();

        expected.add(new PersonCreate(0, "1", "2", 3, "4"));
        StorageOfPersons personStorage = new StorageOfPersons(expected);
        List<PersonCreate> actual = Helper.getAllByLastName("2", personStorage);
        assertEquals(expected, actual);

    }

    @Test
    public void deleteAllTest() {

        Helper.deleteAll(this.personStorage );
        assertEquals(this.personStorage.getPersons().size(), 0);

    }
}
