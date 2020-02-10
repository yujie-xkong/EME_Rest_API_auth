package com.primeeme.restapi.model;

public class PatientIdentifier {
    private final Integer identifierTypeID;
    private final String identifierValue;

    public PatientIdentifier(Integer identifierTypeID, String identifierValue) {
        this.identifierTypeID = identifierTypeID;
        this.identifierValue = identifierValue;
    }
    public Integer getIdentifierTypeID(){
        return identifierTypeID;
    }
    public String getIdentifierValue(){
        return identifierValue;
    }
}
