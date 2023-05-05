package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The PersonService class provides methods for managing Person objects using a PersonDao instance.
 */
@Service
public class PersonService {

    private final PersonDao personDao;

    /**
     * Constructs a new PersonService with the given PersonDao instance.
     *
     * @param personDao The PersonDao instance to use for managing Person objects.
     */
    @Autowired
    public PersonService(@Qualifier("InitialDAO") PersonDao personDao) {
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

    /**
     * Returns all Person objects from the database.
     * @return a List of Person with all Person objects from the database.
     */
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    /**
     * Returns a Person object with a specified id from the database.
     * @param id the id of the Person object.
     * @return a Person with a specified id from the database.
     */
    public Optional<Person> getPersonByID(UUID id) {
        return personDao.selectPersonById(id);
    }

    /**
     * Deletes a Person object with a specified id from the database.
     * @param id the id of the Person object to delete.
     * @return 0 if the specified id is not found. 1 if the specified id is found and the Person object has been deleted.
     */
    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    /**
     * Updates a Person object with a specified id from the database.
     * @param id the id of the Person object to delete.
     * @param person the updated Person object.
     * @return 0 if the specified id is not found. 1 if the specified id is found and the Person object has been updated.
     */
    public int updatePerson(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
}
