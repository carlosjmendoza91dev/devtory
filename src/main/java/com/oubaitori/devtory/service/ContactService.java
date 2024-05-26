package com.oubaitori.devtory.service;

import com.oubaitori.devtory.exception.business.ContactAlreadyExistsException;
import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact saveContact(Contact contact) throws ContactAlreadyExistsException {
        if(contactRepository.existsByName(contact.getName()))
            throw new ContactAlreadyExistsException();

        return contactRepository.save(contact);
    }

}
