package com.primeeme.restapi.api;

import com.primeeme.restapi.model.Patient;
import com.primeeme.restapi.service.PatientIdentifierService;
import com.primeeme.restapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    private PatientIdentifierService patientIdentifierService;

    @GetMapping("/Patient/v1/getPatient")
    public Patient getPatientbyId(@RequestParam("id") Integer id) {
        return patientService.getPatientById(id);
    }

    /*
    @PostMapping("/....")
    public int addP(Patient patient){
        id = patientService.addP(P);
        for i in patient.getPatientIdentifierList():
             i.set(aaaa)
             patientIdentifierService.addPatientIdentifier(i)
    }
     */
}
