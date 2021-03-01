package test;

import org.junit.Test;

import static com.github.project.utils.ReadingAndClearingData.readFile;
import static org.junit.Assert.assertEquals;

class CleanerFileTest {

    @Test
    public void readFileTest() {
        String expected = "123456";

        String actual = readFile("./fileTest/fileTest.txt");

        assertEquals(expected, actual);
    }
}
