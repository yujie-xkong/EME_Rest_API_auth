package com.primeeme.restapi.api;

import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    private ContactService contact;
    @GetMapping("/Contact/v1/getContact")
    public Contact getContactById(@RequestBody Integer id){
        return contact.getContactById(id);
    }
}
