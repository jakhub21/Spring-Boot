package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String listPeople(Model model) {
        model.addAttribute("people", personService.getPeople());
        return "list";
    }

    @GetMapping("/{index}")
    public String getPerson(@PathVariable int index, Model model) {
        model.addAttribute("person", personService.getPerson(index));
        return "person";
    }

    @GetMapping("/add")
    public String addPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @PostMapping
    public String addPerson(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }
}
