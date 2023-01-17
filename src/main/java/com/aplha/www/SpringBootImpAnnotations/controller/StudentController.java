package com.aplha.www.SpringBootImpAnnotations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aplha.www.SpringBootImpAnnotations.bean.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	// http://localhost:8080/student
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "tony", "stark");
//		return new ResponseEntity<>(student, HttpStatus.OK);
//		return ResponseEntity.ok(student);
		return ResponseEntity
				.ok()
				.header("custom-header", "TOM")
				.body(student);
	}
	
	// http://localhost:8080/students
	@GetMapping("/")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students=new ArrayList<>();
		students.add(new Student(1, "tom", "sharma"));
		students.add(new Student(2, "jerry", "agrawal"));
		students.add(new Student(3, "tony", "stark"));
		students.add(new Student(4, "john", "carter"));
		return ResponseEntity.ok(students);
	}
	
	// spring boot REST API with path variable
	// {id} -> URI template variable
	// http://localhost:8080/students/1
//	@GetMapping("students/{id}")
//	public Student studentPathVariable(@PathVariable int id) {
//		return new Student(id, "tony", "stark");
//	}
	
	// http://localhost:8080/students/1/tony/stark
	@GetMapping("/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVariable(
			@PathVariable("id") int studentId, 
			@PathVariable("first-name") String firstName, 
			@PathVariable("last-name") String lastName) {
		Student student = new Student(studentId, firstName, lastName);
		return ResponseEntity.ok(student);
	}
	
	// spring boot REST API with request param
	// http://localhost:8080/students/query?id=1&firstName=TONY&lastName=STARK
	@GetMapping("/query")
	public ResponseEntity<Student> studentRequestVariable(
			@RequestParam int id,
			@RequestParam String firstName, 
			@RequestParam String lastName) {
		Student student = new Student(id, firstName, lastName);
		return ResponseEntity.ok(student);
	}
	
	// spring boot REST API that handles HTTP POST request - creating new resource
	// http://localhost:8080/students/create
	@PostMapping("/create")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	// spring boot REST API that handles HTTP PUT request - updating existing resource
	// http://localhost:8080/students/5/update
	@PutMapping("/{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}
	
	// spring boot REST API that handles HTTP DELETE request - deleting the existing resource
	// http://localhost:8080/students/3/delete
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		return ResponseEntity.ok("student with id: "+studentId+" deleted successfully.");
	}
}
