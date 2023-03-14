package com.todoapp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "contacts")
public class Contact{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID")
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOB_NO")
    private int mobNo;

    @Column(name = "ADDRESS")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobNo() {
        return mobNo;
    }

    public void setMobNo(int mobNo) {
        this.mobNo = mobNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
