package com.todoapp.service;

import com.todoapp.model.Event;
import com.todoapp.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event addEvent(Event event) {
        return eventRepo.save(event);
    }

    public List<Event> getEvents() {
        return eventRepo.findAll();
    }
}
