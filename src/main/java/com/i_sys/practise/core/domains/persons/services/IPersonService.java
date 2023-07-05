package com.i_sys.practise.core.domains.persons.services;

import com.i_sys.practise.data.persons.Person;
import com.i_sys.practise.web.controllers.persons.dto.PersonDtoPostOrPut;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface IPersonService {
    List<Person> getAllPersons() throws Exception;

    Person getPersonById(UUID id) throws Exception;

    Person createPerson(PersonDtoPostOrPut person) throws Exception;

    Person updatePerson(UUID id, PersonDtoPostOrPut person) throws Exception;

    void deletePerson(UUID id) throws Exception;
}
