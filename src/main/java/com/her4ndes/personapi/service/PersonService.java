package com.her4ndes.personapi.service;

import com.her4ndes.personapi.dto.mapper.PersonMapper;
import com.her4ndes.personapi.dto.request.PersonDTO;
import com.her4ndes.personapi.dto.response.MessageResponseDTO;
import com.her4ndes.personapi.entity.Person;
import com.her4ndes.personapi.exception.PersonNotFoundExcepetion;
import com.her4ndes.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private   PersonRepository personRepository;
    private  final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        return createMessageResponse(savedPerson.getId(), "Created person with ID: ");

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
         return allPeople.stream()
                 .map(personMapper::toDTO)
                 .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundExcepetion {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);

    }

    public void deletById( Long id) throws PersonNotFoundExcepetion{
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateByid(Long id, PersonDTO personDTO) throws PersonNotFoundExcepetion{
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person savedPerson  = personRepository.save(personToUpdate);

        return createMessageResponse(savedPerson.getId(),"Person successfully updated with ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundExcepetion {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundExcepetion(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
