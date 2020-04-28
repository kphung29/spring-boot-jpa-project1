package com.cvshealth.springbootjpaproject.controller;

import com.cvshealth.springbootjpaproject.dao.PersonRepo;
import com.cvshealth.springbootjpaproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepo repo;

    @RequestMapping("/")
    public String home() {

        return "home.html";
    }

    @GetMapping("/people")
    public List<Person> getPeople() {

        return repo.findAll();
        //System.out.println(repo.findByTech("Java"));
        //System.out.println(repo.findByIdGreaterThan(1000));
        //System.out.println(repo.findByTechSorted("Java"));
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {

        repo.save(person);
        return person;
    }

    @RequestMapping("/person/{id}")
    public Optional<Person> getPerson(@PathVariable("id") int id) {

        return repo.findById(id);
    }

    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable("id") int id) {

        repo.deleteById(id);
        return "Deleted";
    }

    @PutMapping("/person")
    public Person saveOrUpdatePerson(@RequestBody Person person) {

        repo.save(person);
        return person;
    }
}
