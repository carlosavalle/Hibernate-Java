package com.company;

import javax.persistence.*;
// this is the students class that will be use with hibernate to interact with the db.
// set the table name
@Entity
@Table(name = "students")

public class Student {
    //set it as primary key and autogenerate the id on the db
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // set the fistname and last name, and the attributes for each column
    @Column(name = "firstName", length = 128, nullable = true, unique = false)
    private String firstName;

    @Column(name = "lastName", length = 128, nullable = true, unique = false)
    private String lastName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
