package com.todoapp.controller;

import com.todoapp.model.Person;
import com.todoapp.model.Task;
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
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getTasks();
        if(tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/events/{id}/tasks")
    public ResponseEntity<List<Task>> getAllTasksByEventId(@PathVariable("id") int id) {
        List<Task> tasks = taskService.getTaskByEventId(id);
        if(tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}/tasks")
    public ResponseEntity<List<Task>> getAllTasksByPersonId(@PathVariable("id") int id) {
        List<Task> tasks = taskService.getTasksByPerson(id);
        if(tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
        Task newTask = taskService.addTask(task);
        return new ResponseEntity<>(newTask,HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable("id")int id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTaskStatus(id,task);
        return new ResponseEntity<>(updatedTask,HttpStatus.OK);
    }

}
