package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	//to fetch  all student records
	public List<Student> getStudent();   
	
	
	//to fetch only one student by id
	public Student getStudentById(Integer id);
	//to fetch only one student by id
	public Student getStudentByName(String name);
	//to insert student to db
	public Student postStudent(Student student);
	//to delete a student record
	public String deleteStudentById(Integer id);
	//to update a student record (put)
	public String updateStudentById(Integer id, Student updatingstudent) ;
	
	

}
