package com.example.demo.dao;

import com.example.demo.model.Person;

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
}
