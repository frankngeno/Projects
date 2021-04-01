package com.geniousOfAfrica.controller;

import com.geniousOfAfrica.customErrorResponse.StudentErrorResponse;
import com.geniousOfAfrica.customErrorResponse.StudentNotFoundException;
import com.geniousOfAfrica.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data ... only once!
	

	public void loadData() {
	
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel", "patel@gmail.com"));
		theStudents.add(new Student("Mario", "Rossi", "mario@gmail.com"));
		theStudents.add(new Student("Mary", "Smith", "email@gmail.com"));
	}
	
	
	
	// define endpoint for "/students" - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
			
		return theStudents;
	}
	
	// define endpoint for "/students/{studentId}" - return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// just index into the list ... keep it simple for now
		
		// check the studentId against list size
		
		if ( (studentId >= theStudents.size()) || (studentId < 0) ) {			
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
		
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}	
}
