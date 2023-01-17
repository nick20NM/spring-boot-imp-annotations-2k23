package com.aplha.www.SpringBootImpAnnotations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	// spring boot REST API with path variable
	// {id} -> URI template variable
	// http://localhost:8080/students/1
//	@GetMapping("students/{id}")
//	public Student studentPathVariable(@PathVariable int id) {
//		return new Student(id, "tony", "stark");
//	}
	
	// http://localhost:8080/students/1/tony/stark
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(
			@PathVariable("id") int studentId, 
			@PathVariable("first-name") String firstName, 
			@PathVariable("last-name") String lastName) {
		return new Student(studentId, firstName, lastName);
	}
	
	// spring boot REST API with request param
	// http://localhost:8080/students/query?id=1&firstName=TONY&lastName=STARK
	@GetMapping("students/query")
	public Student studentRequestVariable(
			@RequestParam int id,
			@RequestParam String firstName, 
			@RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}
	
	// spring boot REST API that handles HTTP POST request
	// http://localhost:8080/students/create
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
}
