package com.tcs.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.student.entity.Student;
import com.tcs.student.service.StudentService;



@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createstudent")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    
    @GetMapping("/welcom")
    public String welcome(){
    	return "Welcom to Student rest api";
    }

    @GetMapping("/showallstudents")
    public List<Student> getAllStudents() {
    	//System.out.println(studentService.getAllStudents()+"teja..........");
        return studentService.getAllStudents();
    }

    @GetMapping("/getbyid/{id}")
    public Student getStudentById(@PathVariable int id) {
    	
        return studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
}

