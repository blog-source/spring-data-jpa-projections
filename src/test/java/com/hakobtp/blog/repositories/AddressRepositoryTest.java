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
        assertEquals("Armavir", address.getStreet());
    }
}