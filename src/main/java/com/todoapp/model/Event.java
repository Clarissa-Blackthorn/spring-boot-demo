package com.todoapp.model;

import jakarta.persistence.*;


import java.util.Date;


@Entity
@Table(name = "events")
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private int id;

    @Column(name = "EVENT_NAME")
    private String eventName;

    @Column(name = "EVENT_DESC")
    private String eventDesc;

    @Column(name = "EVENT_DATE")
    private Date eventDate;

    @Column(name = "EVENT_STATUS")
    private String eventStatus;

    public int getEventId() {
        return id;
    }

    public void setEventId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

}
