package com.hakobtp.blog.prujections;

import org.springframework.beans.factory.annotation.Value;

public interface StudentInfoView {

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    String getEmail();


    AddressView getAddress();

    interface AddressView {
        @Value("#{target.state + '/' + target.city}")
        String getFullAddress();
    }
}