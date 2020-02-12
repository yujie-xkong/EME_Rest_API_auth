package com.primeeme.restapi.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
public class Patient {
    private  Integer patientID;
    private  Contact contact;
    private  String ssn;
    private  Address address;
    private  String ContactPhone;
    private  List<PatientIdentifier> patientIdentifierList;
    private  Integer active_status;

    public Patient(String ssn, String firstName, String middleName, String lastName,
                   String suffix, String address1, String address2, String city, String state,
                   Integer postal, String dateOfBirth, String phoneNumber,
                   Integer patientID, Contact contact, String contactPhone,
                   List<PatientIdentifier> patientIdentifierList, Integer active_status,
                   String gender) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date inputDateOfBirth = formatter.parse(dateOfBirth);
        Contact patientContact = new Contact(firstName, middleName, lastName,
                                             suffix, inputDateOfBirth, gender);

        this.contact = contact;
        ContactPhone = contactPhone;
        this.active_status = active_status;
        Address patientAddress = new Address(address1, address2, city, state, postal);
        this.ssn = ssn;
        this.address = patientAddress;
        this.patientIdentifierList = patientIdentifierList;
    }
}
