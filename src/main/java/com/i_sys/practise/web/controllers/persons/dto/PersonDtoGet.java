package com.i_sys.practise.web.controllers.persons.dto;

import com.i_sys.practise.data.persons.Person;
import java.util.UUID;

public class PersonDtoGet {
    public UUID id;
    public String firstName;
    public String lastName;
    public String patronymic;

    public PersonDtoGet (Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.patronymic = person.getPatronymic();
    }
}
