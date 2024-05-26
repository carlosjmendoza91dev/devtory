package com.oubaitori.devtory.service;

import com.oubaitori.devtory.dto.ContactDTO;
import com.oubaitori.devtory.exception.business.ContactAlreadyExistsException;
import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact saveContact(ContactDTO contactDTO) throws ContactAlreadyExistsException {
        if(contactRepository.existsByName(contactDTO.getName()))
            throw new ContactAlreadyExistsException();

        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDTO, contact);
        return contactRepository.save(contact);
    }

}
