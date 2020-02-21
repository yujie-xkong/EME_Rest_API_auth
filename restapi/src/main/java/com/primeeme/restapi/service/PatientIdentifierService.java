package com.primeeme.restapi.service;

import com.primeeme.restapi.model.PatientIdentifier;

import java.util.List;

public interface PatientIdentifierService {
    PatientIdentifier getPatientIdentifierById(Integer id);
    int addPatientIdentifier(PatientIdentifier patientIdentifier);
    List<PatientIdentifier> getPatientIdentifierByPatientId(Integer id);
}
