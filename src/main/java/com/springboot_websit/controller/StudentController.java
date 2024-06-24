package com.springboot_websit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot_websit.entity.Student;
import com.springboot_websit.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studnetService;

	public StudentController(StudentService studnetService) {
		super();
		this.studnetService = studnetService;
	}
	// view the data
	@GetMapping("/students")
	public String listStudnet(Model model) {
		model.addAttribute("Student",studnetService.getAllStudents());
		return "student";
	}
	
	// enter the value input
	@GetMapping("/student/new")
	public String createrStudentForm(Model model) {
		// create student object to hold studnet from data
	Student student = new Student();
	model.addAttribute("Student",student);
	return "create_student";
}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
	    studnetService.saveStudent(student);
	    return "redirect:/students";
	}

	@GetMapping("/student/edit/{id}")
	public String editStudentfrom(@PathVariable Long id,Model model){
	model.addAttribute("student",studnetService.getStudentById(id));
	return "edit_student";
	}
	
	// update value 
	@PostMapping("/students/{id}")
	public  String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student ,Model model) {
		
	Student existingStudent = studnetService.getStudentById(id);
	existingStudent.setId(id);
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	
	studnetService.updateStudent(existingStudent);
	return "redirect:/students";
		
	}
	 @GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
	studnetService.deleteStudentById(id);	
	return "redirect:/students";
	}
	
	
	
}