package com.todoapp.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private int id;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "TASK_STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event;

    @ManyToMany
    @JoinTable(name = "TASKS_PERSONS",
            joinColumns = {@JoinColumn(name = "TASK_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERSON_ID")}
    )
    private Set<Person> assignedPersons;

    public int getId() {
        return id;
    }

    public Set<Person> getAssignedPersons() {
        return assignedPersons;
    }

    public void setAssignedPersons(Set<Person> assignedPersons) {
        this.assignedPersons = assignedPersons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
