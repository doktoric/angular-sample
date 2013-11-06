package com.acme.doktoric.service.impl;

import com.acme.doktoric.dto.Person;
import com.acme.doktoric.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class InMemoryPersonService implements PersonService {
    private Map<Integer, Person> persons = new HashMap<Integer, Person>();

    public InMemoryPersonService() {
        persons.put(1, new Person(1, "Vilma", "Flinstone"));
        persons.put(2, new Person(2, "Fredy", "Flinstone"));
    }

    public List<Person> getAllPersons() {
        return new ArrayList<Person>(persons.values());
    }

    public void addPerson(Person person) {
        int id = 1;
        while (persons.get(id) != null) {
            id++;
        }
        person.setId(id);
        persons.put(id, person);
    }

    public void deletePerson(int id) {
        persons.remove(id);
    }
}
