package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.serviceimpl.StudentServiceImpl;

@RestController
public class StudentController {
	
	StudentServiceImpl studentService;
	
	public StudentController(StudentServiceImpl studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	
	// find list of students=========>http://localhost:8080/get
	@GetMapping(value="/get")
	public List<Student>getStudent(){
		return studentService.getStudent();
	}
	
	
	
	
	
	//fetch only one student by id (chatgpt)(only changes in controller
	
	/*
	@Autowired
	    private StudentRepository studentRepository;

	@GetMapping("/students/{id}/name")
    public ResponseEntity<String> getStudentNameById(@PathVariable int id) {
       
		Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id));
        return ResponseEntity.ok(student.getName());
    }
    */
	
	
	
	//fetch only one student by id (showed in class)(changes only in controller and serviceimpl and service)
	@GetMapping(value="/getbyid/{id}")
	public Student getStudentById(@PathVariable Integer id){
		return studentService.getStudentById(id);
	}
	
	
	//fetch by name
	@GetMapping(value="/getbyname/{name}")
	public Student getStudentByName(@PathVariable String name){
		return studentService.getStudentByName(name);
	}
	
	
	
	
	/*  //chatgpt  fetch by name
	  @Autowired
	    private StudentRepository studentRepository;

	    @GetMapping("/students")
	    public ResponseEntity<Student> getStudentByName(@RequestParam String name) {
	        Student student = studentRepository.findByName(name);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	   */
	
	
	
	//to insert a student to DB
	@PostMapping(value="/post")
	public Student postStudent(@RequestBody Student student){
		return studentService.postStudent(student);
	}
	
	
	
	//to delete a record
	@DeleteMapping(value="/delete/{id}")
	public String deleteStudentById(@PathVariable Integer id){
		return studentService.deleteStudentById(id);
	}
	
	
	
	//to update the record(put)===========>http://localhost:8080/put/2
	@PutMapping(value="/put/{id}")
	public String updateStudentById(@PathVariable Integer id,@RequestBody Student updatingstudent){
		return studentService.updateStudentById(id,updatingstudent);
	}
	
}
