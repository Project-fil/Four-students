package com.github.project.checks;

import com.github.project.people.personStorage;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;


class IdChecksTest {

    @Test
    void getByIdForUpdate(Integer id, personStorage personStorage) {

        assertNotNull(id);

    }
}