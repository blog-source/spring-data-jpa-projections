package com.hakobtp.blog.repositories;

import com.hakobtp.blog.dto.AddressDto;
import com.hakobtp.blog.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<AddressDto> findByZipCode(String zipCode);
}