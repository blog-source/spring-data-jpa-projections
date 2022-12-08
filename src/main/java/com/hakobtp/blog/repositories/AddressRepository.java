package com.hakobtp.blog.repositories;

import com.hakobtp.blog.dto.AddressDto;
import com.hakobtp.blog.dto.StudentInfoDto;
import com.hakobtp.blog.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<AddressDto> findByZipCode(String zipCode);

    @Query("SELECT a.student.id as studentId, a.student.email as email, a.city as city  " +
            "FROM Address a WHERE a.zipCode = :zipCode")
    List<javax.persistence.Tuple> findStudentsEmailAndIdAndCityByZipCode(@Param("zipCode") String zipCode);

    @Query("SELECT new com.hakobtp.blog.dto.StudentInfoDto(student.id, a.student.email,  a.city)" +
            "FROM Address a WHERE a.zipCode = :zipCode")
    List<StudentInfoDto> findStudentsInfoByZipCode(@Param("zipCode") String zipCode);
}