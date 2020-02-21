package com.primeeme.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PatientIdentifier {
    private Integer patientIdentifierId;
    private Integer patientId;

    private Integer identifierTypeId;

    private String identifierValue;
    private boolean active_status = false;

    public PatientIdentifier(Integer patientId,
                             Integer identifierTypeId,
                             String identifierValue){
        this.patientId = patientId;
        this.identifierTypeId = identifierTypeId;
        this.identifierValue = identifierValue;
    }

    public PatientIdentifier(@JsonProperty("identifierTypeId") Integer identifierTypeId,
                             @JsonProperty("identifierValue") String identifierValue){
        this.identifierTypeId = identifierTypeId;
        this.identifierValue = identifierValue;
    }

    public PatientIdentifier(Integer patientId, Integer identifierTypeId, String identifierValue, boolean active_status)
    {
        this.patientId = patientId;
        this.identifierTypeId = identifierTypeId;
        this.identifierValue = identifierValue;
        this.active_status = active_status;
    }
}
