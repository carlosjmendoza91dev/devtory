package com.oubaitori.devtory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oubaitori.devtory.dto.ContactDTO;
import com.oubaitori.devtory.exception.business.ContactAlreadyExistsException;
import com.oubaitori.devtory.model.Contact;
import com.oubaitori.devtory.service.ContactService;
import org.assertj.core.util.Lists;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = ContactController.class)
@ExtendWith(MockitoExtension.class)
public class ContactControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContactService contactService;

    private ContactDTO contactDTO;

    @BeforeEach
    public void init(){
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
    void testShouldCreateNewContact() throws Exception {
        given(contactService.saveContact(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/contact")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contactDTO))
        );
        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(contactDTO.getName())));
    }

}
