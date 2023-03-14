package com.todoapp.service;

import com.todoapp.model.Person;
import com.todoapp.model.Task;
import com.todoapp.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public List getTasks() {
        return taskRepo.findAll();
    }

    public Task updateTaskStatus(int id, Task task) {
        Optional<Task> taskData = taskRepo.findById(id);
        Task _task = taskData.get();
        _task.setStatus(task.getStatus());
        return(taskRepo.save(_task));
    }

    public List<Task> getTaskByEventId(int id) {
        return taskRepo.findByEventId(id);
    }

    public List<Task> getTasksByPerson(int id) {
        return taskRepo.findByAssignedPersonsId(id);
    }


}
