package com.example.demo.model;

import java.util.UUID;

/**
 * The Person class represents an individual with a unique ID and a name.
 * Person is the main model we are using in the application.
 */
public class Person {

    /** Unique ID of the person. **/
    private final UUID id;

    /** Name of the person. **/
    private final String name;

    /**
     * Creates a new Person object with the specified ID and name.
     * @param id Unique ID of the person.
     * @param name Name of the person.
     */
    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the unique ID of the person.
     * @return The unique ID of the person.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Returns the name of the person.
     * @return The name of the person.
     */
    public String getName() {
        return this.name;
    }
}
