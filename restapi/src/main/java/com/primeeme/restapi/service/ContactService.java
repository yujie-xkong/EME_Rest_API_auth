package com.primeeme.restapi.service;

import com.primeeme.restapi.model.Contact;

import javax.management.Query;

public interface ContactService {
    Contact getContactById(Integer id);
}
