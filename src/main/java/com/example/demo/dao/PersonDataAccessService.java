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
    /**
     * Retrieves all Person objects in the database.
     * @return a List of all Person objects in the database.
     */
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    /**
     * Retrieves a Person object with a specified id.
     * @param id the id of the Person object to retrieve.
     * @return an Optional containing the Person object with the specified id, or empty if no Person object with the specified id is found.
     */
    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    /**
     * Deletes Person object with specified id from the database.
     * @param id the id of the Person to delete.
     * @return 1 if a Person object with a certain id has been deleted. 0 if no person with specified id has been found.
     */
    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> delPerson = selectPersonById(id);
        if (delPerson.isEmpty()) {
            return 0;
        }
        DB.remove(delPerson.get());
        return 1;
    }

    /**
     * Updates Person object with specified id in the database.
     * @param id the id of the Person to update.
     * @param person updated Person.
     * @return 1 if a Person object with a certain id ahs been deleted. 0 if no person with specified id has been found.
     */
    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int indexOfPersonToUpdate = DB.indexOf(p);
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
