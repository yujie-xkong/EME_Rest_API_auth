package com.primeeme.restapi.api;

import com.alibaba.fastjson.JSONObject;
import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.model.Patient;
import com.primeeme.restapi.model.PatientIdentifier;
import com.primeeme.restapi.model.bo.PatientWrapper;
import com.primeeme.restapi.service.ContactService;
import com.primeeme.restapi.service.PatientIdentifierService;
import com.primeeme.restapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientWrapperController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientIdentifierService patientIdentifierService;

    @GetMapping("/PatientWrapper/v1/getPatient")
    public PatientWrapper getPatientById(@RequestParam("id") Integer id){
        Patient patient = patientService.getPatientById(id);
        Contact contact = null;
        if (patient.getContactId() != null){
            int contactId = patient.getContactId();
            contact = contactService.getContactById(contactId);
        }
        System.out.println(contact);
        List<PatientIdentifier> patientIdentifierList = patientIdentifierService.getPatientIdentifierByPatientId(id);
        PatientWrapper patientWrapper = new PatientWrapper(patient, contact, patientIdentifierList);
        return patientWrapper;
    }


    @PostMapping("/PatientWrapper/v1/addPatient")
    public int addPatient(@RequestBody PatientWrapper patientWrapper){
        //create contact
        Integer patientId = 0;
        System.out.println(patientWrapper);
        Integer contactId = contactService.addContact(patientWrapper.getContact());
        if (contactId != 0) {
            patientWrapper.getPatient().setContactId(contactId);
            patientId = patientService.addPatient(patientWrapper.getPatient());
        }
        else {
            return 0;
        }

        for (PatientIdentifier patientIdentifier : patientWrapper.getPatientIdentifierList()){
            patientIdentifier.setPatientId(patientId);
            Integer idenId = patientIdentifierService.addPatientIdentifier(patientIdentifier);
            if (idenId == 0 ) {
                return 0;
            }
        }
        return patientId;
    }


}


