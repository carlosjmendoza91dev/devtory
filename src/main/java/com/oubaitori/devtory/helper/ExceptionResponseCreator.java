package com.oubaitori.devtory.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExceptionResponseCreator {

    public ResponseEntity<Object> createExceptionResponse(String message, HttpStatus httpStatus){
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        return new ResponseEntity<>(map, httpStatus);
    }
}
