package com.CRUD.student_crud.repository;

import com.CRUD.student_crud.model.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Integer is the type of primary key (rollno)
	Optional<Student> findByRollno(Integer rollno);
}
