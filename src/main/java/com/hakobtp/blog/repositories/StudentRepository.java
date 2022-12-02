package com.hakobtp.blog.repositories;

import com.hakobtp.blog.entities.Student;
import com.hakobtp.blog.prujections.StudentInfoView;
import com.hakobtp.blog.prujections.StudentView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<StudentView> getByEmail(String email);

    StudentInfoView getByFirstName(String firstName);

    <T> T findByFirstName(String firstName, Class<T> clazz);

}
