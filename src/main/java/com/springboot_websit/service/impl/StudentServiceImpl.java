package com.springboot_websit.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot_websit.entity.Student;
import com.springboot_websit.repositary.StudentRepositary;
import com.springboot_websit.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepositary studentRepositary;
	
	
	public StudentServiceImpl(StudentRepositary studentRepositary) {
		super();
		this.studentRepositary = studentRepositary;
	}


	@Override
	public  List<Student> getAllStudents(){
		 return studentRepositary.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentRepositary.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		 return studentRepositary.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		return studentRepositary.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepositary.deleteById(id);
	}
	
	
}
