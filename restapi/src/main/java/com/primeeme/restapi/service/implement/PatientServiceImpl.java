package com.primeeme.restapi.service.implement;

import com.primeeme.restapi.mapper.PatientMapper;
import com.primeeme.restapi.model.Patient;
import com.primeeme.restapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Patient getPatientById(Integer id) {
        return patientMapper.getPatientById(id);
    }
}
