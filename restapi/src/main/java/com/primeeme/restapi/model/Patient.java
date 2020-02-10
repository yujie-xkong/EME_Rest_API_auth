package com.primeeme.restapi.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
public class Patient {
    private final String ssn;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String suffix;
    private final Address address;
    private final Date dateOfBirth;
    private final String phoneNumber;
    private final List<PatientIdentifier> patientIdentifierList;

    public Patient(String ssn, String firstName, String middleName, String lastName,
                   String suffix, String address1, String address2, String city, String state,
                   Integer postal, String dateOfBirth, String phoneNumber,
                   List<PatientIdentifier> patientIdentifierList) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Address patientAddress = new Address(address1, address2, city, state, postal);
        this.ssn = ssn;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.address = patientAddress;
        this.dateOfBirth = formatter.parse(dateOfBirth);
        this.phoneNumber = phoneNumber;
        this.patientIdentifierList = patientIdentifierList;
    }
}
