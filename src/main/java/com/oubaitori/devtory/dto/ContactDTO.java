package com.oubaitori.devtory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ContactDTO {
    private String id;

    private String name;

    private String businessUnit;

    private String tribe;

    private Date admissionDate;

    private List<String> skills;

    private List<String> specialties;

}
