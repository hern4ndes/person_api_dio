package com.her4ndes.personapi.controller;

import com.her4ndes.personapi.dto.MessageResponseDTO;
import com.her4ndes.personapi.entity.Person;
import com.her4ndes.personapi.repository.PersonRepository;


import com.her4ndes.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;


    @Autowired
    public PersonController(PersonRepository personReposiry){
        this.personRepository = personReposiry;
    }
    @PostMapping
    public MessageResponseDTO creatPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID"+savedPerson.getId())
                .build();

    }
}
