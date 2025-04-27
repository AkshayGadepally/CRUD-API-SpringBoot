package com.CRUD.student_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.student_crud.model.Student;
import com.CRUD.student_crud.service.StudentNotFoundException;
import com.CRUD.student_crud.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")

public class StudentController {
	
	@Autowired
	
	private StudentService studentService;
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{rollno}")
	public ResponseEntity<Student> getStudentByRollno(@PathVariable Integer rollno) {
		Student student = studentService.getStudentByRollno(rollno);
		return ResponseEntity.ok(student);
	}

	@PutMapping("/{rollno}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer rollno,@RequestBody Student updatedStudent){
		try{
			Student updated = studentService.updateStudent(rollno,updatedStudent);
			return ResponseEntity.ok(updated);
		}catch(RuntimeException e){
			return ResponseEntity.status(400).body(null);
		}
	}
	
	@DeleteMapping("/{rollno}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer rollno){
		try {
			studentService.deleteStudent(rollno);
			return ResponseEntity.ok("The student details with the current details of the rollno"+rollno+" have been removed");
		}catch(Exception e) {
			return ResponseEntity.status(404).body("Student not found with roll number " + rollno);
		}
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}