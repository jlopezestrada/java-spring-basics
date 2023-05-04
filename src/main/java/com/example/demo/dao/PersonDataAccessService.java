package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("InitialDAO")
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

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
