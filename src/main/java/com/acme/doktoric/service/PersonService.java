package com.acme.doktoric.service;

import com.acme.doktoric.dto.Person;

import java.util.List;


public interface PersonService {
    List<Person> getAllPersons();

    void addPerson(Person person);

    void deletePerson(int id);
}
