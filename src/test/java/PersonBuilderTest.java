import com.company.persons.Person;
import com.company.scanner.ScannerPers;
import com.company.StorageOfPersons;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PersonBuilderTest {
    @Test
    public void createPersonTest(){
        StorageOfPersons personStorage = new StorageOfPersons(new ArrayList<Person>());
        Person expected = new Person(0,"lolo", "wow20,"kyiv");
                Person actual = ScannerPers.createPerson(personStorage,"lolo
                "lolo", 20,"kyiv");
        assertEquals(expected,actual);
    }
}
