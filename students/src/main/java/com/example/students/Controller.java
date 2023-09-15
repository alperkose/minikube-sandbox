package com.example.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class Controller {

    private Service studentService;

    @Autowired
    public Controller(Service studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return this.studentService.student(studentId);
    }

    @PostMapping("")
    public Student saveStudent(@RequestBody Student student) {
        return this.studentService.create(student);
    }
}
