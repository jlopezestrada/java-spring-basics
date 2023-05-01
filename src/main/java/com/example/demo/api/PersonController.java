package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }
}
