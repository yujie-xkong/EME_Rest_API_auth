package com.primeeme.restapi.service;

import com.primeeme.restapi.model.PatientIdentifier;

public interface PatientIdentifierService {
    PatientIdentifier getPatientIdentifierById(Integer id);
    int addPatientIdentifier(PatientIdentifier patientIdentifier);
}
