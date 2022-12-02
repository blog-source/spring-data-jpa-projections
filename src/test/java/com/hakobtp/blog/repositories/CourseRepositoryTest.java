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
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void getByNumberTest() {
        var courseViewOptional = courseRepository.getByNumber(1);

        assertFalse(courseViewOptional.isEmpty());
        var courseView = courseViewOptional.get();

        assertEquals(courseView.getNumber(), 1);
        assertEquals(courseView.getTitle(), "Java");
        assertEquals(courseView.getAuthor(), "James Gosling");
    }

    @Test
    void getByAuthorTest() {
        var list = courseRepository.getByAuthor("James Gosling");

        assertFalse(list.isEmpty());
        assertEquals(list.size(), 1);

        var course = list.get(0);
        assertEquals(course.getNumber(), 1);
        assertEquals(course.getTitle(), "Java");

        var students = course.getStudents();
        assertFalse(students.isEmpty());
        assertEquals(students.size(), 1);

        var student = students.get(0);
        assertEquals(student.getEmail(), "gurgen@mail.com");
        assertEquals(student.getFirstName(), "Gurgen");
    }
}