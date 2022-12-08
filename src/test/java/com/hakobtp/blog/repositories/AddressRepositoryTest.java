package com.hakobtp.blog.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@Sql(scripts = "/insert_data.sql")
@Sql(scripts = "/clean_up_data.sql", executionPhase = AFTER_TEST_METHOD)
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void findByZipCodeTest() {
        var listOfAddress = addressRepository.findByZipCode("00001");

        assertFalse(listOfAddress.isEmpty());
        assertEquals(1, listOfAddress.size());
        var address = listOfAddress.get(0);

        assertEquals("Armavir", address.getCity());
        assertEquals("Tumanyan", address.getStreet());
    }

    @Test
    void findStudentsEmailAndIdAndCityByZipCode() {
        var tuples = addressRepository.findStudentsEmailAndIdAndCityByZipCode("00001");
        assertEquals(1, tuples.size());

        var tuple = tuples.get(0);
        assertEquals(1, tuple.get("studentId", Long.class));
        assertEquals("Armavir", tuple.get("city", String.class));
        assertEquals("gurgen@mail.com", tuple.get("email", String.class));
    }

    @Test
    void findStudentsInfoByZipCode() {
        var students = addressRepository.findStudentsInfoByZipCode("00001");
        assertEquals(1, students.size());

        var student = students.get(0);
        assertEquals(1, student.getStudentId());
        assertEquals("Armavir", student.getCity());
        assertEquals("gurgen@mail.com", student.getEmail());
    }
}
