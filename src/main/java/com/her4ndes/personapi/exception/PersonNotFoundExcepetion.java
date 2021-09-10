package com.her4ndes.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundExcepetion extends Exception {
    public PersonNotFoundExcepetion(Long id) {
        super("Person not found with id " + id );
    }
}
