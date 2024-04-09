package com.oubaitori.devtory.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("contact")
@AllArgsConstructor
public class Contact {

    @Id
    private String id;

    private String name;

    private String businessUnit;

    private String tribe;

    private Date admissionDate;

    private List<String> skills;

    private List<String> specialties;

}
