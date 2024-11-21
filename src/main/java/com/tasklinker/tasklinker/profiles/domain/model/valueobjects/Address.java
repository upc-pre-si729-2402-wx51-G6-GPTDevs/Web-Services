package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record Address(String street, String numberStreet, String district, String postalCode, String city, String country) {

    public Address(){this(null,null,null,null,null,null);}

    public Address {
        if(street==null || street.isBlank()){
            throw new IllegalArgumentException("Street incorrect syntax");
        }
        if(numberStreet==null || numberStreet.isBlank()){
            throw new IllegalArgumentException("Number Street incorrect syntax");
        }
        if(district==null || district.isBlank()){
            throw new IllegalArgumentException("City incorrect syntax");
        }
        if(postalCode==null || postalCode.isBlank()){
            throw new IllegalArgumentException("State incorrect syntax");
        }
        if(city==null || city.isBlank()){
            throw new IllegalArgumentException("PostalCode incorrect syntax");
        }
        if(country==null || country.isBlank()){
            throw new IllegalArgumentException("Country incorrect syntax");
        }
    }

    public String getAddress() {
        return String.format("%s %s, %s, %s, %s, %s", street, numberStreet, district, postalCode, city, country);
    }

}
