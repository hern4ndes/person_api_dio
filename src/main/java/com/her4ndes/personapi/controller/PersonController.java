package com.her4ndes.personapi.controller;

import com.her4ndes.personapi.dto.MessageResponseDTO;
import com.her4ndes.personapi.entity.Person;
import com.her4ndes.personapi.repository.PersonRepository;


import com.her4ndes.personapi.repository.PersonRepository;
import com.her4ndes.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RespectBinding;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO creatPerson(@RequestBody Person person) {
        return personService.creatPerson(person);
    }

}
