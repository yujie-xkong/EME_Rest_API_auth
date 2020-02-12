package com.primeeme.restapi.model;

import java.util.Date;

public class Contact {
    private  Integer contactID;
    private  String firstName;
    private  String middleName;
    private  String lastName;
    private  String suffix;
    private  Date dateOfBirth;
    private  String gender;


    public Contact(String firstName, String middleName,
                   String lastName, String suffix, Date dateOfBirth,
                   String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

}
