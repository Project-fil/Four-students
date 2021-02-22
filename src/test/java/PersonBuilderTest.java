import com.github.persons.Peoples;
import com.github.view.Scanner;
import com.github.persons.PersonsData;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PersonBuilderTest {
    @Test
    public void createPersonTest(){
        PersonsData personStorage = new PersonsData(new ArrayList<Peoples>());
        Peoples expected = new Peoples(0,"lolo", "wow20", 2,"kyiv");
                Peoples actual = Scanner.createPerson(personStorage,"lolo",
                "lolo", 20, "kyiv");
        assertEquals(expected,actual);
    }
}
