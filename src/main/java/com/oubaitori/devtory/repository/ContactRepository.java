package com.oubaitori.devtory.repository;

import com.oubaitori.devtory.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
    boolean existsByName(String name);
}