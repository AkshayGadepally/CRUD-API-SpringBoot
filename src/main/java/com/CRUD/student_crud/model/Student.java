package com.CRUD.student_crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int rollno;
	private String grade;
	
	public  Student() {}
	
	public  Student(String name,int rollno,String grade) {
		this.name = name;
		this.rollno =rollno;
		this.grade = grade;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		 this.rollno = rollno;
	}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
