package com.hakobtp.blog.prujections;

import java.util.List;

public interface CurseAuthorStudentView {

    String getTitle();

    Integer getNumber();

    List<CourseStudentView> getStudents();

    interface CourseStudentView {

        String getFirstName();

        String getEmail();
    }
}