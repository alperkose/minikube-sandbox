package com.example.students;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    private Repository studentRepo;

    @Autowired
    public Service(Repository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student student(Long id) {
        return studentRepo.findById(id).get();
    }

    public Student create(Student st) {
        return studentRepo.save(st);
    }


}
