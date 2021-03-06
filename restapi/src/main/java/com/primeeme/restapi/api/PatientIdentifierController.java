package com.primeeme.restapi.api;

import com.primeeme.restapi.model.PatientIdentifier;
import com.primeeme.restapi.service.PatientIdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientIdentifierController {
    @Autowired
    private PatientIdentifierService patientIdentifierService;

    @GetMapping("/PatientIdentifier/v1/getPatientIdentifier")
    public PatientIdentifier getPatientIdentifierById(@RequestParam("id") Integer id){
        return patientIdentifierService.getPatientIdentifierById(id);
    }

    @PostMapping("/PatientIdentifier/v1/addPatientIdentifier")
    public int addPatientIdentifier(@RequestBody PatientIdentifier patientIdentifier){
        patientIdentifierService.addPatientIdentifier(patientIdentifier);
        if (patientIdentifier.getPatientIdentifierId() != null){
            return patientIdentifier.getPatientIdentifierId();
        }else {
            return 0;
        }
    }

    @GetMapping("/PatientIdentifier/v1/getPatientIdentifierByPatientId")
    public List<PatientIdentifier> getPatientIdentifierByPatientId(@RequestParam("patientId") Integer patientId){
        return patientIdentifierService.getPatientIdentifierByPatientId(patientId);
    }
}
