package com.primeeme.restapi.model;

public class PatientIdentifier {
    private final Integer patientID;
    private final Integer identifierTypeID;
    private final String identifierValue;
    private final Integer active_status;

    public PatientIdentifier(Integer patientID, Integer identifierTypeID, String identifierValue, Integer active_status) {
        this.patientID = patientID;
        this.identifierTypeID = identifierTypeID;
        this.identifierValue = identifierValue;
        this.active_status = active_status;
    }
    public Integer getIdentifierTypeID(){
        return identifierTypeID;
    }
    public String getIdentifierValue(){
        return identifierValue;
    }
}
