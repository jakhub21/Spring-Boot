package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;


@Service
@org.springframework.web.context.annotation.SessionScope
public class PersonService {
    private List<Person> people;

    @PostConstruct
    public void init() {
        people = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("Jan");
        person1.setFamilyName("Kowalski");

        Person person2 = new Person();
        person2.setFirstName("Anna");
        person2.setFamilyName("Nowak");

        people.add(person1);
        people.add(person2);
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int index) {
        return people.get(index);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void setPerson(int index, Person person) {
        people.set(index, person);
    }

    public void removePerson(int index) {
        people.remove(index);
    }
}
