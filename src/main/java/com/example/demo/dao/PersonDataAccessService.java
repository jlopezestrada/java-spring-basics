package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonDataAccessService implements PersonDao {

    /** List used to store the database of Person objects. **/
    private static List<Person> DB = new ArrayList<>();

    /**
     * Inserts a Person into the data store with a given UUID.
     *
     * @param id     The UUID of the Person object to insert.
     * @param person The Person object to insert.
     * @return Status of the operation.
     */
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
