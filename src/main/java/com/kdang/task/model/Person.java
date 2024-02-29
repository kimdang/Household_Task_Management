package com.kdang.task.model;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use database auto-increment
    @Column(name = "person_id")
        private long personID;

    @Column(name = "first_name")
        private String firstName;

    @Column(name = "last_name")
        private String lastName;

    @Column(name = "family_id")
        private long familyID;

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getFamilyID() {
        return familyID;
    }

    public void setFamilyID(long familyID) {
        this.familyID = familyID;
    }
}
