package com.primeeme.restapi.api;

import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/Contact/v1/getContact")
    public Contact getContactById(@RequestParam("id") Integer id){
        return contactService.getContactById(id);
    }

    @PostMapping("/Contact/v1/addContact")
    public int addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
        if (contact.getContactID() != null ){
            return contact.getContactID();
        }else {
            return 0;
        }
    }
}
