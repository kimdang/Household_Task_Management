package com.kdang.task.service;

import com.kdang.task.model.Person;
import com.kdang.task.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // CREATE
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // READ
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    // UPDATE
    public Person updatePerson(Integer personID, Person personDetails) {
        Person person = personRepository.findById(personID).get();
        person.setFamilyID(personDetails.getFamilyID());
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());

        return personRepository.save(person);
    }

    // DELETE
    public void deletePerson(Integer personID) {
        personRepository.deleteById(personID);
    }
}
