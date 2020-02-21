package com.primeeme.restapi.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.model.Patient;
import com.primeeme.restapi.model.PatientIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PatientWrapper {
    @JsonProperty("patient")
    private Patient patient;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("patientIdentifierList")
    private List<PatientIdentifier> patientIdentifierList;
}
