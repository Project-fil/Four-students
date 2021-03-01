package test.checks.tests;

import org.testng.annotations.Test;

import static junit.framework.TestCase.assertEquals;

class SwitchCommandTest {
    @Test
    public void switchToMenuCheck(String line) {
        String exp = "switch";
        assertEquals(exp, line);

    }
}
