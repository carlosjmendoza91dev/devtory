package com.oubaitori.devtory.exception;

import com.oubaitori.devtory.exception.messages.ExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContactAlreadyExistsException extends Exception{

    public ContactAlreadyExistsException(){
        super(ExceptionMessages.CONTACT_ALREADY_EXISTS.toString());
    }
}
