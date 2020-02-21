package com.primeeme.restapi.service.implement;

import com.primeeme.restapi.mapper.PatientIdentifierMapper;
import com.primeeme.restapi.model.PatientIdentifier;
import com.primeeme.restapi.service.PatientIdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientIdentifierServiceImpl implements PatientIdentifierService {
    @Autowired
    private PatientIdentifierMapper patientIdentifierMapper;
    @Override
    public PatientIdentifier getPatientIdentifierById(Integer id){
        return patientIdentifierMapper.getPatientIdentifierById(id);}

    @Override
    public int addPatientIdentifier(PatientIdentifier patientIdentifier) {
        patientIdentifierMapper.addPatientIdentifier(patientIdentifier);
        return patientIdentifier.getPatientIdentifierId();
    }

    @Override
    public List<PatientIdentifier> getPatientIdentifierByPatientId(Integer id) {
        return patientIdentifierMapper.getPatientIdentifierByPatientId(id);
    }
}
