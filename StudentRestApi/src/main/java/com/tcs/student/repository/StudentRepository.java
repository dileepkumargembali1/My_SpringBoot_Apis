package com.tcs.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
