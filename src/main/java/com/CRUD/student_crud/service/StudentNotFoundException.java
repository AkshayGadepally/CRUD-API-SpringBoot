package com.CRUD.student_crud.service;

public class StudentNotFoundException extends RuntimeException{
		public StudentNotFoundException(String message ) {
			super(message);
		}
}
