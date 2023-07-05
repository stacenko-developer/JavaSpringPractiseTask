package com.i_sys.practise.web.controllers.persons;

import com.i_sys.practise.core.domains.persons.services.IPersonService;
import com.i_sys.practise.data.persons.Person;
import com.i_sys.practise.web.controllers.persons.dto.PersonDtoGet;
import com.i_sys.practise.web.controllers.persons.dto.PersonDtoPostOrPut;
import com.i_sys.practise.web.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final IPersonService personService;
    private static final Logger log = LoggerFactory.getLogger(PersonController.class.getName());

    public PersonController(IPersonService personService) {
       this.personService = personService;
    }

    @GetMapping
    public List<PersonDtoGet> getAllPersons() throws Exception {
        log.info("Call Method of PersonController: getAllPersons()");
        List<PersonDtoGet> result = new ArrayList<>();

        for (Person person : personService.getAllPersons()) {
            result.add(new PersonDtoGet(person));
        }

        log.info("Method of PersonController: getAllPersons(): HttpStatus 200");
        return result;
    }

    @GetMapping({"id"})
    public PersonDtoGet getPersonById(@RequestParam UUID id) throws Exception {
        log.info("Call Method of PersonController: getPersonById(" + id + ")");

        if (id == null) {
            throw new ValidationException("Id is null!");
        }

        PersonDtoGet result = new PersonDtoGet(personService.getPersonById(id));
        log.info("Method of PersonController: getPersonById(" + id + ") HttpStatus 200");
        return result;
    }

    @PostMapping
    public Person createPerson(@RequestBody PersonDtoPostOrPut person) throws Exception {
        log.info("Call Method of PersonController: createPerson(" + person + ")");

        if (person == null) {
            throw new ValidationException("Person is null!");
        }

        Person result = personService.createPerson(person);
        log.info("Call Method of PersonController: createPerson(" + person + ") HttpStatus 200");

        return result;
    }

    @PutMapping({"id"})
    public Person updatePerson(@RequestParam UUID id, @RequestBody PersonDtoPostOrPut person) throws Exception {
        log.info("Call Method of PersonController: updatePerson(" + id + "," + person + ")");

        if (id == null) {
            throw new ValidationException("Id is null!");
        }

        if (person == null) {
            throw new ValidationException("Person is null!");
        }

        Person result = personService.updatePerson(id, person);
        log.info("Call Method of PersonController: updatePerson(" + person + ") HttpStatus 200");

        return result;
    }

    @DeleteMapping({"id"})
    public void deletePerson(@RequestParam UUID id) throws Exception {
        log.info("Call Method of PersonController: deletePerson(" + id + ")");

        if (id == null) {
            throw new ValidationException("Id is null!");
        }

        personService.deletePerson(id);
        log.info("Method of PersonController: deletePerson(" + id + ") HttpStatus 200");
    }
}
