package com.hakobtp.blog.prujections;

import java.util.List;

public interface StudentView {

    String getEmail();

    String getFirstName();

    StudentAddressView getAddress();

    List<StudentCourseView> getCourses();

    interface StudentCourseView {
        String getTitle();

        Integer getNumber();

    }

    interface StudentAddressView {

        String getZipCode();
    }
}
