package com.hakobtp.blog.repositories;

import com.hakobtp.blog.dto.StudentDto;
import com.hakobtp.blog.prujections.StudentInfoView;
import com.hakobtp.blog.prujections.StudentView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@Sql(scripts = "/insert_data.sql")
@Sql(scripts = "/clean_up_data.sql", executionPhase = AFTER_TEST_METHOD)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void getByEmailTest() {
        var studentViewOptional = studentRepository.getByEmail("gurgen@mail.com");

        assertFalse(studentViewOptional.isEmpty());

        var studentView = studentViewOptional.get();
        assertEquals(studentView.getEmail(), "gurgen@mail.com");
        assertEquals(studentView.getFirstName(), "Gurgen");

        assertNotNull(studentView.getAddress());
        assertEquals(studentView.getAddress().getZipCode(), "00001");

        var courses = studentView.getCourses();
        assertFalse(courses.isEmpty());
        assertEquals(courses.size(), 1);

        var course = courses.get(0);
        assertEquals(course.getTitle(), "Java");
        assertEquals(course.getNumber(), 1);
    }

    @Test
    void getByFirstNameTest() {
        var studentInfoView = studentRepository.getByFirstName("Gurgen");
        assertEquals(studentInfoView.getEmail(), "gurgen@mail.com");
        assertEquals(studentInfoView.getFullName(), "Gurgen Aloyan");
        assertEquals(studentInfoView.getAddress().getFullAddress(), "AR/Armavir");
    }

    @Test
    void findByFirstName() {
        var studentInfoView = studentRepository.findByFirstName("Gurgen", StudentInfoView.class);
        assertEquals(studentInfoView.getEmail(), "gurgen@mail.com");
        assertEquals(studentInfoView.getFullName(), "Gurgen Aloyan");
        assertEquals(studentInfoView.getAddress().getFullAddress(), "AR/Armavir");

        var studentView  = studentRepository.findByFirstName("Gurgen", StudentView.class);
        assertEquals(studentView.getEmail(), "gurgen@mail.com");
        assertEquals(studentView.getFirstName(), "Gurgen");

        assertNotNull(studentView.getAddress());
        assertEquals(studentView.getAddress().getZipCode(), "00001");

        var courses = studentView.getCourses();
        assertFalse(courses.isEmpty());
        assertEquals(courses.size(), 1);

        var course = courses.get(0);
        assertEquals(course.getTitle(), "Java");
        assertEquals(course.getNumber(), 1);

        var studentDto  = studentRepository.findByFirstName("Gurgen", StudentDto.class);
        assertEquals(1, studentDto.getId());
        assertEquals(studentView.getFirstName(), "Gurgen");
        assertEquals(studentView.getEmail(), "gurgen@mail.com");

    }
}
