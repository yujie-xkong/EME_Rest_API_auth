package com.primeeme.restapi.api;

import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.model.Patient;
import com.primeeme.restapi.model.PatientIdentifier;
import com.primeeme.restapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/Patient/v1/getPatient")
    public Patient getPatientById(@RequestParam("id") Integer id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/Patient/v1/addPatient")
    public int addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
        if (patient.getPatientId() != null ){
            return patient.getPatientId();
        }else {
            return 0;
        }
    }
}
