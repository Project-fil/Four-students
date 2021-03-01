package test.checks.tests;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


class CheckOnNullTest {

    @Test
    void checkOnNull(String line) {
        String exp = null;
        assertEquals(null, line);
    }
}