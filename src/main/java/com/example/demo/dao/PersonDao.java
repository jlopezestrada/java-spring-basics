package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * PersonDao interface provides methods for managing Person objects.
 */
public interface PersonDao {

    /**
     * Inserts a Person into the data store with a given UUID.
     * @param id        The UUID of the Person object to insert.
     * @param person    The Person object to insert.
     * @return Status of the operation.
     */
    int insertPerson(UUID id, Person person);

    /**
     * Adds a new Person to the data store with a randomly generated UUID.
     * @param person The Person object to add.
     * @return Status of the operation.
     */
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    /**
     * Retrieves all Person objects in the database.
     * @return a List of all Person objects in the database.
     */
    List<Person> selectAllPeople();

    /**
     * Retrieves a Person object with a specified id.
     * @param id the id of the Person object to retrieve.
     * @return an Optional containing the Person object with the specified id, or empty if no Person object with the specified id is found.
     */
    Optional<Person> selectPersonById(UUID id);

    /**
     * Deletes Person object with specified id from the database.
     * @param id the id of the Person to delete.
     * @return 1 if a Person object with a certain id has been deleted. 0 if no person with specified id has been found.
     */
    int deletePersonById(UUID id);

    /**
     * Updates Person object with specified id in the database.
     * @param id the id of the Person to update.
     * @param person updated Person.
     * @return 1 if a Person object with a certain id ahs been deleted. 0 if no person with specified id has been found.
     */
    int updatePersonById(UUID id, Person person);
}
