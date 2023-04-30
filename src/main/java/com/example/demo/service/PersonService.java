package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

/**
 * The PersonService class provides methods for managing Person objects using a PersonDao instance.
 */
public class PersonService {

    private final PersonDao personDao;

    /**
     * Constructs a new PersonService with the given PersonDao instance.
     *
     * @param personDao The PersonDao instance to use for managing Person objects.
     */
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    /**
     * Adds a new Person object to the data store using the PersonDao instance.
     *
     * @param person The Person object to add.
     * @return Status code.
     */
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
