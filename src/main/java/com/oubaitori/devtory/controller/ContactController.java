package com.oubaitori.devtory.controller;

import com.oubaitori.devtory.dto.ContactDTO;
import com.oubaitori.devtory.exception.business.ContactAlreadyExistsException;
import com.oubaitori.devtory.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) throws ContactAlreadyExistsException {
        ContactDTO createdContactDTO = contactService.saveContact(contactDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContactDTO);
    }
}
