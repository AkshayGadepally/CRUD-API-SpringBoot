package com.CRUD.student_crud.service;

import com.CRUD.student_crud.model.Student;
import com.CRUD.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	//Add Student 
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//Get all Student Details
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	//Get Student by Roll No
	public Student getStudentByRollno(Integer rollno){
		return studentRepository.findByRollno(rollno)
				.orElseThrow(()->new StudentNotFoundException("Student with roll number " + rollno + " not found"));
	}
	
	//Update Student
	public Student updateStudent(int currentrollno,Student updatedStudent) {
		 Optional<Student> existingStudentopt = studentRepository.findByRollno(currentrollno);
		 Student student = existingStudentopt.get();

		 if(existingStudentopt.isPresent()) {
						 
			 if(updatedStudent.getRollno() != currentrollno && 
					 studentRepository.findByRollno(updatedStudent.getRollno()).isPresent()) {
				 throw new RuntimeException("Roll no"+updatedStudent.getRollno()+"already exists");
			 }
			 
			 student.setName(updatedStudent.getName());
			 student.setRollno(updatedStudent.getRollno());
			 student.setGrade(updatedStudent.getGrade());
			 return studentRepository.save(student);
		 }
		 else {
			 throw new RuntimeException("There is no student with mentioned rollno :"+currentrollno);
		 }	
	}
	
	//Delete Student
	public void deleteStudent(Integer rollno) {
		studentRepository.deleteById(rollno);
	}
		
}
