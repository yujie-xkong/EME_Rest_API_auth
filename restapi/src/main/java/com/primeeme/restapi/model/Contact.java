package com.primeeme.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Data
public class Contact {
    private  Integer contactID;
    private  String firstName;
    private  String middleName;
    private  String lastName;
    private  String suffix;
    private  Date dateOfBirth;
    private  String gender;


    // For http POST
    public Contact(@JsonProperty("firstName") String firstName,
                   @JsonProperty("middleName") String middleName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("suffix") String suffix,
                   @JsonProperty("gender") String gender,
                   @JsonProperty("dateOfBirth") String dateOfBirth
                   ) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date inputDateOfBirth = null;
        if (dateOfBirth != null){
            inputDateOfBirth = formatter.parse(String.valueOf(dateOfBirth));
        }
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.dateOfBirth = inputDateOfBirth;
        this.gender = gender;
    }
    // For http GET
    public Contact(Integer id, String firstName, String middleName,
                   String lastName, String suffix, String gender,
                   Timestamp dateOfBirth
    ) throws ParseException {
        Date inputDateOfBirth = null;
        if (dateOfBirth != null){
            inputDateOfBirth = new Date(dateOfBirth.getTime());
        }
        this.contactID = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.dateOfBirth = inputDateOfBirth;
        this.gender = gender;
    }
}
