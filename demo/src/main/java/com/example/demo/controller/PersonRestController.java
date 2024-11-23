package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index) {
        try {
            return ResponseEntity.ok(personService.getPerson(index));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Person added successfully.");
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> updatePerson(@PathVariable int index, @RequestBody Person person) {
        try {
            personService.setPerson(index, person);
            return ResponseEntity.ok("Person updated successfully.");
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.");
        }
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deletePerson(@PathVariable int index) {
        try {
            personService.removePerson(index);
            return ResponseEntity.ok("Person removed successfully.");
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.");
        }
    }
}
