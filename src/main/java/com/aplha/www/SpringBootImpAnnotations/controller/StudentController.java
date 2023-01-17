package com.aplha.www.SpringBootImpAnnotations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplha.www.SpringBootImpAnnotations.bean.Student;

@RestController
public class StudentController {

	// http://localhost:8080/student
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "tony", "stark");
		return student;
	}
	
	// http://localhost:8080/students
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		students.add(new Student(1, "tom", "sharma"));
		students.add(new Student(2, "jerry", "agrawal"));
		students.add(new Student(1, "tony", "stark"));
		students.add(new Student(1, "john", "carter"));
		return students;
	}
}
