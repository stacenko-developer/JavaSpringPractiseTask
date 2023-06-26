package com.i_sys.practise.core.domains.persons.services;

import com.i_sys.practise.core.domains.persons.repositories.IPersonRepository;
import com.i_sys.practise.data.persons.Person;
import com.i_sys.practise.web.controllers.persons.dto.PersonDtoPostOrPut;
import com.i_sys.practise.web.exceptions.NotFoundException;
import com.i_sys.practise.web.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService implements IPersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class.getName());
    private final IPersonRepository personRepository;

    @Autowired
    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() throws Exception {
        log.info("Call Method of PersonService: getAllPersons()");

        var result = new ArrayList<Person>();

        log.info("Method of PersonService: getAllPersons() successfully completed");

        return result;
    }

    public Person getPersonById(UUID id) throws Exception {
        log.info("Call Method of PersonService: getPersonById(" + id + ")");

        var person = personRepository.findById(id).orElse(null);

        if (person == null) {
            throw new NotFoundException("The person with the specified id was not found in the system!");
        }

        log.info("Method of PersonService: getPersonById(" + id + ") successfully completed");

        return person;
    }

    public void createPerson(PersonDtoPostOrPut person) throws Exception {
        log.info("Call Method of PersonService: createPerson(" + person + ")");

        if (person == null || person.firstName == null || person.lastName == null || person.patronymic == null) {
            throw new ValidationException("Person or person's data are null!");
        }

        personRepository.save(new Person(person.firstName, person.lastName, person.patronymic));

        log.info("Call Method of PersonService: createPerson(" + person + ") successfully completed");
    }


    public void updatePerson(UUID id, PersonDtoPostOrPut person) throws Exception {
        log.info("Call Method of PersonService: updatePerson(" + id + "," + person + ")");

        if (person == null || person.firstName == null || person.lastName == null || person.patronymic == null) {
            throw new ValidationException("Person or person's data are null!");
        }

        var entity = personRepository.findById(id).orElse(null);

        if (entity == null) {
            throw new NotFoundException("The person with the specified id was not found in the system!");
        }

        entity.setFirstName(person.firstName);
        entity.setLastName(person.lastName);
        entity.setPatronymic(person.patronymic);

        personRepository.save(entity);

        log.info("Call Method of PersonService: updatePerson(" + id + "," + person + ") successfully completed");
    }


    public void deletePerson(UUID id) throws Exception {
        log.info("Call Method of PersonService: deletePerson(" + id + ")");
        var result = personRepository.findById(id).orElse(null);

        if (result == null) {
            throw new NotFoundException("The person with the specified id was not found in the system!");
        }

        personRepository.delete(result);
        log.info("Method of PersonService: deletePerson(" + id + ") successfully completed");
    }
}