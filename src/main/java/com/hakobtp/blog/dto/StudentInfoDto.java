package com.hakobtp.blog.dto;

public class StudentInfoDto {
    //region fields declaration

    private Long studentId;
    private String email;
    private String city;

    //endregion fields declaration

    //region constructors

    public StudentInfoDto(Long studentId, String email, String city) {
        this.studentId = studentId;
        this.email = email;
        this.city = city;
    }

    //endregion constructors

    //region getters and setters

    public Long getStudentId() {
        return studentId;
    }

    public StudentInfoDto setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentInfoDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCity() {
        return city;
    }

    public StudentInfoDto setCity(String city) {
        this.city = city;
        return this;
    }

    //endregion getters and setters
}
