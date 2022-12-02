package com.hakobtp.blog.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class AddressDto {
    //region fields declaration

    private String city;
    private String street;

    //region fields declaration

    //region constructors

    public AddressDto(String city, String street) {
        this.city = city;
        this.street = street;
    }

    //endregion constructors

    //region getters ans setters

    public String getCity() {
        return city;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    //endregion getters and setters

    //region equals, hashCode and toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDto that = (AddressDto) o;

        if (!Objects.equals(city, that.city)) return false;
        return Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddressDto.class.getSimpleName() + "[", "]")
                .add("city='" + city + "'")
                .add("street='" + street + "'")
                .toString();
    }

    //endregion equals, hashCode and toString
}
