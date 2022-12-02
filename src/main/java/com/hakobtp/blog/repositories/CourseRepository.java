package com.hakobtp.blog.repositories;

import com.hakobtp.blog.entities.Course;
import com.hakobtp.blog.prujections.CourseView;
import com.hakobtp.blog.prujections.CurseAuthorStudentView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<CourseView> getByNumber(Integer number);

    List<CurseAuthorStudentView> getByAuthor(String author);

}