package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl {
	
	
	@Autowired
	StudentRepository studentRepository;

 /*	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;      //if constr is not desfined then do autowired annotation
	}*/                                                  
	
   
	
	public List<Student> getStudent(){
    	return studentRepository.findAll();
    }

    
    
    
    
    //to fetch only one student by id
	public Student getStudentById(Integer id) {
		
		 Optional<Student> student = studentRepository.findById(id);
		 return student.orElse(null);
	}
	





//to fetch record by name
	public Student getStudentByName(String name) {
		
		return studentRepository.findByName(name);
	
	}




//to insert
	public Student postStudent(Student student) {
		// TODO Auto-generated method stub
		Student s = studentRepository.save(student);	
		return s;
	}




//to delete a student record
	public String deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
		return "delete syccess";
	}




	//to update the record(put)
	public String updateStudentById(Integer id, Student updatingstudent) {                    
		//get the record from db
		 Optional<Student> existingstudent=	studentRepository.findById(id);	
		 
		 if(existingstudent.isPresent()) {
		
			 //modify in app layer(java)
			 Student student1 = existingstudent.get();
			 student1.setName(updatingstudent.getName()); //getters setters method
			 
			 //save the update record
			 studentRepository.save(student1);
			 
			 return "update sucess";
			 
		 }
		 
		 else {
			 return "record not found";	
		 }
																	 
	}

}
