import com.company.Persons.PersonCreate;
import com.company.Scanner.ScannerPers;
import com.company.StorageOfPersons;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PersonBuilderTest {
    @Test
    public void createPersonTest(){
        StorageOfPersons personStorage = new StorageOfPersons(new ArrayList<PersonCreate>());
        PersonCreate expected = new PersonCreate(0,"lolo", "wow20,"kyiv");
        PersonCreate actual = ScannerPers.createPerson(personStorage,"lolo
                "lolo", 20,"kyiv");
        assertEquals(expected,actual);
    }
}
