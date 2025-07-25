package com.tcs.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.student.entity.Student;
import com.tcs.student.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
    private StudentRepository repository;

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
    	//System.out.println(repository.findAll()+"teja..........");
        return repository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repository.findById(id);
    }
}
