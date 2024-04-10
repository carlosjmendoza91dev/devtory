package com.oubaitori.devtory.controller;

import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }
}
