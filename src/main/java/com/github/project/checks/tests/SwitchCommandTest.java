package com.github.project.checks.tests;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

class SwitchCommandTest {
    @Test
    public void switchToMenuCheck(String line) {
        String exp = "switch";
        assertEquals(exp, line);

        assertNotNull(line);
    }
}
