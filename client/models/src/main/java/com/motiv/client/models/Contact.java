package com.motiv.client.models;

import javax.persistence.*;

@Entity
@Table
public class Contact {

    /*
    public Contact(int id, int number, int extension, String name, Status status, boolean motivSupport) {
        this.id = id;
        this.number = number;
        this.extension = extension;
        this.name = name;
        this.status = status;
        this.motivSupport = motivSupport;
    } */

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int number; // DID number

    @Column
    private int extension; // Local extension number

    @Column(nullable = false)
    private String name;

    @Enumerated
    private Status status;

    @Column
    private boolean motivSupport; // Support for integrated functionality provided by Motiv.

    @Entity
    private enum Status {
        Available,
        Away,
        Busy,
        DD, // Don't disturb
        OoO // Out-of-office
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean getMotivSupport() {
        return motivSupport;
    }

    public void setMotivSupport(boolean motivSupport) {
        this.motivSupport = motivSupport;
    }
}
