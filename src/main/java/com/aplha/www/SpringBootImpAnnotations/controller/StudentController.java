package com.aplha.www.SpringBootImpAnnotations.controller;

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
}
