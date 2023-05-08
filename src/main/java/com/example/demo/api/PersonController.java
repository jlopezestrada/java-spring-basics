package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * PersonController class represents a controller for managing Person objects.
 * It is responsible for adding new Person objects through the PersonService.
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    /** The PersonService object used for adding new Person objects. **/
    private final PersonService personService;

    /**
     * Constructs a new PersonController with the specified PersonService.
     * @param personService The PersonService used for adding new Person objects.
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Adds a new Person using PersonService object.
     * @param person New Person to be created.
     */
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    /**
     * Returns all the people stored in the DB of PersonService object.
     * @return List of people stored in DB.
     */
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    /**
     * Return a Person object with a specified id from the database.
     * @param id the id of the Person.
     * @return Person object with a specified id.
     */
    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id")UUID id) {
        return personService.getPersonByID(id).orElse(null);
    }

    /**
     * Delete a Person object with a specified id from the database.
     * @param id the id of the Person.
     */
    @DeleteMapping(path = "/{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    /**
     * Update a Person object with a specified id from the database.
     * @param id the id of the Person.
     * @param person the updated Person.
     */
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person) {
        personService.updatePerson(id, person);
    }
}
