package com.primeeme.restapi.model;

public class Address {
    private final String address1;
    private final String address2;
    private final String city;
    private final String state;
    private final Integer postal;

    public Address(String address1, String address2, String city, String state, Integer postal) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postal = postal;
    }

    public String getAddress1(){
        return address1;
    }
    public String getAddress2(){
        return address2;
    }
    public String getCity(){
        return city;
    }

}
