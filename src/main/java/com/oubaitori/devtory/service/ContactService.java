package com.oubaitori.devtory.service;

import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository itemRepository;

    public Contact saveContact(Contact contact){
        return itemRepository.save(contact);
    }

}
