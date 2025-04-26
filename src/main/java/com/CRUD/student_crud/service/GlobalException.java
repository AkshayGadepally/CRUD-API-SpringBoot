package com.CRUD.student_crud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalException {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String,String>> handleStudentNotFoundException(StudentNotFoundException ex){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error", ex.getMessage() );
		return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> GlobalException(Exception ex){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error","Something went wrong"+ ex.getMessage());
		return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
