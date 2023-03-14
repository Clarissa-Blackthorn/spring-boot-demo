package com.todoapp.controller;

import com.todoapp.model.Contact;
import com.todoapp.model.Person;
import com.todoapp.model.Task;
import com.todoapp.service.ContactService;
import com.todoapp.service.PersonService;
import com.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ContactService contactService;


    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getPersons();
        if(persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/persons/contacts/{id}")
    public ResponseEntity<Optional<Contact>> getContactById(@PathVariable(value = "id")int id){
        Optional<Contact> contact = contactService.getContactById(id);
        if(contact.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contact,HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}/persons")
    public ResponseEntity<List<Person>> getPersonsByAssignedTask(@PathVariable(value = "id")int id) {
        List<Person> persons = personService.getPersonByAssignedTaskId(id);
        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(persons,HttpStatus.OK);
    }

    @GetMapping("/persons/{name}")
    public ResponseEntity<Optional<Person>> getPersonByName(@PathVariable(value="name")String name) {
        Optional<Person> person = personService.getPersonByPersonName(name);
        if(person.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
        Person newPerson = personService.addPerson(person);
        return new ResponseEntity<>(newPerson,HttpStatus.CREATED);
    }
}
