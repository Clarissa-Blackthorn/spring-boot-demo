package com.todoapp.repo;

import com.todoapp.model.Contact;
import com.todoapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {
    List<Person> findByAssignedTasksId(int id);

    Person findByPersonName(String name);
}
