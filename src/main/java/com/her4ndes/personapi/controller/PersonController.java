package com.her4ndes.personapi.controller;

import com.her4ndes.personapi.dto.request.PersonDTO;
import com.her4ndes.personapi.dto.response.MessageResponseDTO;


import com.her4ndes.personapi.entity.Person;
import com.her4ndes.personapi.exception.PersonNotFoundExcepetion;
import com.her4ndes.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }
    @GetMapping
    public List<PersonDTO> listAll(){
        return  personService.listAll();
    }
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundExcepetion {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deletById(@PathVariable Long id) throws PersonNotFoundExcepetion{
        System.out.println(id);
        personService.deletById(id);

    }
    @PutMapping("/{id}")
    public MessageResponseDTO upadateByid(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundExcepetion{
        return personService.updateByid(id,personDTO);
    }
}
