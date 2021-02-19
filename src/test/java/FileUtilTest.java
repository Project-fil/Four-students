import com.company.Utils.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FileUtilTest {

    @Test
    public void readFileTest() {
        String expected = "123456";

        String actual = FileUtil.readFile("./fileTest/fileTest.txt");

        assertEquals(expected, actual);

    }

    @Test
    public void writeFileTest() {

        String data = "123456";

        FileUtil.writeFile(new File("./fileTest/fileTest2.txt"),
                false, data);

        String actual = FileUtil.readFile("./fileTest/fileTest2.txt");

        assertEquals(data, actual);

    }

    @Test
    public void getResultFromFileTest() {
        String data = "0 1 2 3 4";

        String actual = FileUtil.getResultFromFile("./fileTest/jsTest.json");

        assertEquals(data, actual);
    }
}
