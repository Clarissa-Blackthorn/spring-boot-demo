package com.todoapp.service;

import com.todoapp.model.Contact;
import com.todoapp.model.Person;
import com.todoapp.model.Task;
import com.todoapp.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> getPersons() {
        return personRepo.findAll();
    }

    public Optional<Person> getPersonByPersonName(String name) {
        return Optional.ofNullable(personRepo.findByPersonName(name));
    }

    public List<Person> getPersonByAssignedTaskId(int id) {
        return personRepo.findByAssignedTasksId(id);
    }

}
