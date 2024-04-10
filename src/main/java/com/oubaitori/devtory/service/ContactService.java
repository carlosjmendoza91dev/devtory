package com.oubaitori.devtory.service;

import com.oubaitori.devtory.exception.ContactAlreadyExistsException;
import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public ResponseEntity<Object> saveContact(Contact contact) {

        try {
            if(contactRepository.existsByName(contact.getName()))
                throw new ContactAlreadyExistsException();

            return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.CREATED);
        } catch (Exception e)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }


    }

}
