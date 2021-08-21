package com.her4ndes.personapi.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private long id;

    private String fistName;

    private String lastName;

    private String cpf;

    private LocalDate birthDate;

    private List<Phone> phones;

}
