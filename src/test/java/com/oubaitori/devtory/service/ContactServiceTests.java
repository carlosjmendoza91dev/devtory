package com.oubaitori.devtory.service;

import com.oubaitori.devtory.dto.ContactDTO;
import com.oubaitori.devtory.exception.business.ContactAlreadyExistsException;
import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.repository.ContactRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
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

    private Contact contact;
    private ContactDTO contactDTO;
    private String contactName;

    @BeforeEach
    public void init(){
        contactName = "Carlos Mendoza";
        contact = Contact.builder().name(contactName).build();
        contact.setName(contactName);
        contactDTO = new ContactDTO(
                "UUID",
                "Carlos Mendoza",
                "Loans",
                "Card",
                new Date(),
                Lists.newArrayList("PHP"),
                Lists.newArrayList("Logging")
        );
    }

    @Test
    void testShouldSaveNewContact() throws ContactAlreadyExistsException {

        //Arrange
        when(contactRepository.save(any(Contact.class))).thenReturn(contact);

        //Act
        var savedContact = contactService.saveContact(contactDTO);

        //Assert
        assertThat(savedContact.getName()).isEqualTo(contactDTO.getName());
    }

    @Test
    void testShouldThrowContactAlreadyExistsException() {
        when(contactRepository.existsByName(contactName)).thenReturn(true);
        assertThrows(ContactAlreadyExistsException.class, () -> contactService.saveContact(contactDTO));
    }

}
