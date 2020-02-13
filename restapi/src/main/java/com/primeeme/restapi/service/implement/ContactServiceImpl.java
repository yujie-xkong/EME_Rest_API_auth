package com.primeeme.restapi.service.implement;

import com.primeeme.restapi.mapper.ContactMapper;
import com.primeeme.restapi.model.Contact;
import com.primeeme.restapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper contactMapper;
    @Override
    public Contact getContactById(Integer id) {
        return contactMapper.getContactById(id);
    }

    @Override
    public int addContact(Contact contact) {
        contactMapper.addContact(contact);
        return contact.getContactID();
    }
}
