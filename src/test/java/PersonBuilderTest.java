import com.github.persons.Person;
import com.github.utils.ScannerPers;
import com.github.persons.PersonsData;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PersonBuilderTest {
    @Test
    public void createPersonTest(){
        PersonsData personStorage = new PersonsData(new ArrayList<Person>());
        Person expected = new Person(0,"lolo", "wow20", 2,"kyiv");
                Person actual = ScannerPers.createPerson(personStorage,"lolo",
                "lolo", 20, "kyiv");
        assertEquals(expected,actual);
    }
}
