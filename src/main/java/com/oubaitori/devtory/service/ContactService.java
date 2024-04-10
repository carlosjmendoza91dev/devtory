package com.oubaitori.devtory.service;

import com.oubaitori.devtory.exception.business.ContactAlreadyExistsException;
import com.oubaitori.devtory.helper.ExceptionResponseCreator;
import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ExceptionResponseCreator exceptionResponseCreator;

    public ResponseEntity<Object> saveContact(Contact contact) {

        try {
            if(contactRepository.existsByName(contact.getName()))
                throw new ContactAlreadyExistsException();

            return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.CREATED);
        } catch (Exception e)
        {
            return exceptionResponseCreator.createExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
