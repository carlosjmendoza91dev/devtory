package com.oubaitori.devtory.service;

import com.oubaitori.devtory.exception.business.ContactAlreadyExistsException;
import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.repository.ContactRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactServiceTests {

    @Mock
    ContactRepository contactRepository;

    @InjectMocks
    ContactService contactService;

    @Test
    void testShouldSaveNewContact() throws ContactAlreadyExistsException {

        //Arrange
        Contact contact = new Contact(
                "UUID",
                "Carlos Mendoza",
                "Loans",
                "Card",
                new Date(),
                Lists.newArrayList("PHP"),
                Lists.newArrayList("Logging")
        );

        //Act
        when(contactRepository.save(any(Contact.class))).thenReturn(contact);
        var savedContact = contactService.saveContact(contact);

        //Assert
        assertThat(savedContact).isEqualTo(contact);
    }

    @Test
    void testShouldThrowContactAlreadyExistsException() {

        String contactName = "Carlos Mendoza";

        Contact contact = new Contact(
                "UUID",
                contactName,
                "Loans",
                "Card",
                new Date(),
                Lists.newArrayList("PHP"),
                Lists.newArrayList("Logging")
        );

        when(contactRepository.existsByName(contactName)).thenReturn(true);
        assertThrows(ContactAlreadyExistsException.class, () -> contactService.saveContact(contact));

    }

}
