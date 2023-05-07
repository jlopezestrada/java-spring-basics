package com.example.demo.dao;

import com.example.demo.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonDataAccessServiceTest {

    private PersonDao personDao;

    @BeforeEach
    void setUp() {
        personDao = new PersonDataAccessService();
    }

    @AfterEach
    void tearDown() {
        personDao = null;
    }

    @Test
    void insertPerson() {
        UUID id = UUID.randomUUID();
        String name = "Name Test";
        Person person = new Person(id, name);

        int result = personDao.insertPerson(id, person);

        assertEquals(1, result);
        List<Person> allPeople = personDao.selectAllPeople();
        assertEquals(1, allPeople.size());
        assertEquals(id, allPeople.get(0).getId());
        assertEquals(name, allPeople.get(0).getName());
    }

    @Test
    void selectAllPeopleEmptyDB() {
        List<Person> allPeople = personDao.selectAllPeople();
        assertEquals(0, allPeople.size());
    }

    @Test
    void selectAllPeople() {
        for (int i = 0; i < 5; i++) {
            personDao.insertPerson(new Person(UUID.randomUUID(), "Test " + i));
        }

        List<Person> allPeople = personDao.selectAllPeople();
        assertEquals(5, allPeople.size());
    }

    @Test
    void selectPersonById() {
        // given
        UUID id = UUID.randomUUID();
        String name = "John Doe";
        Person person = new Person(id, name);
        personDao.insertPerson(id, person);

        Optional<Person> result = personDao.selectPersonById(id);

        assertTrue(result.isPresent());
        assertEquals(name, result.get().getName());
    }

    @Test
    void deletePersonById() {
        UUID id = UUID.randomUUID();

        personDao.insertPerson(id, new Person(id, "Delete Person"));
        assertEquals(1, personDao.selectAllPeople().size());

        personDao.deletePersonById(id);
        assertEquals(0, personDao.selectAllPeople().size());
    }

    @Test
    void updatePersonById() {
        UUID id = UUID.randomUUID();

        personDao.insertPerson(id, new Person(id, "Test Before"));
        Optional<Person> originalPerson = personDao.selectPersonById(id);
        assertTrue(originalPerson.isPresent());

        personDao.updatePersonById(id, new Person(id, "Test After"));
        Optional<Person> updatedPerson = personDao.selectPersonById(id);
        assertTrue(updatedPerson.isPresent());
        assertNotEquals("Test Before", updatedPerson.get().getName());
    }
}