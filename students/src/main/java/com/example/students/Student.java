package com.example.students;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "students")
public class Student {

    @Id
    private Long id;

    private String name;

    protected Student(){}
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
