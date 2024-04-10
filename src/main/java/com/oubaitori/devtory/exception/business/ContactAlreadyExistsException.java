package com.oubaitori.devtory.exception.business;

import com.oubaitori.devtory.exception.messages.ExceptionMessages;

public class ContactAlreadyExistsException extends Exception {

    public ContactAlreadyExistsException(){
        super(ExceptionMessages.CONTACT_ALREADY_EXISTS.toString());
    }
}
