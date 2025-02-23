package com.cdac.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdac.studentmanagement.model.Student;
import com.cdac.studentmanagement.service.StudentService;


/**
*Author :Gautam Sharma
*Date   :17-Feb-2025
*Time   :1:10:04 am
*/

@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/")
	public String displayHomePage() {
		return "index";
	}
	
	@GetMapping("/new")
	public String getMethodName(Model m) {
		Student student = new Student();
		m.addAttribute(student);
		return "student-form";
	}
	
	@PostMapping("/student")
	public String postMethodName(@ModelAttribute("student") Student stud) {
		studentservice.savestudent(stud);
		return "redirect:/student";
	}
	

	@GetMapping("/student")
	public String liststudent(Model model) {
		List<Student> students=studentservice.getallstudent();
		model.addAttribute("stud",students);
		return "student-list";
	}
	
	
	@GetMapping("/update/{studId}")
	public String updateStudentform (@PathVariable int studId ,Model model) {
		Student student=studentservice.getsinglestudetn(studId);
		model.addAttribute("student",student);
		return "student-form";
	}
	
	@PostMapping("Student/{studId}")
	public String updatestudent (@PathVariable int studId ,@ModelAttribute ("student") Student student ) {
		student.setStudId(studId);
		studentservice.update(student);
		return "redirect:/student";
	}
	
	@GetMapping("/delete/{studId}")
	public String deletestudent (@PathVariable int  studId) {
		studentservice.delete(studId);
		return "redirect:/student";
	}
	
	
	@GetMapping("/shopping")
	public String getMethodName() {
		return "shopping";
	}
}
