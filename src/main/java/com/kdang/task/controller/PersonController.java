package com.kdang.task.controller;

import com.kdang.task.model.Person;
import com.kdang.task.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PersonController {
    private final PersonService personService;

    public PersonController (PersonService personService) {
        this.personService = personService;
    }

    // CREATE
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    // READ
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> readPersons() {
        return personService.getPersons();
    }

    // UPDATE
    @RequestMapping(value = "/persons/{personID}", method = RequestMethod.PUT)
    public Person updatePerson(@PathVariable(value = "personID") Integer personID,
                               @RequestBody Person personDetails) {
        return personService.updatePerson(personID, personDetails);
    }

    // DELETE
    @RequestMapping(value = "/persons/{personID}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable(value = "personID") Integer personID) {
        personService.deletePerson(personID);
    }
}
