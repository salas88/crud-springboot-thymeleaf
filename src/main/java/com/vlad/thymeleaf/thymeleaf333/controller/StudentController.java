package com.vlad.thymeleaf.thymeleaf333.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vlad.thymeleaf.thymeleaf333.entity.Student;
import com.vlad.thymeleaf.thymeleaf333.entity.StudentDetail;
import com.vlad.thymeleaf.thymeleaf333.service.IService;
import com.vlad.thymeleaf.thymeleaf333.service.IServiceDetail;

@Controller
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private IService iService;
	
	@Autowired
	private IServiceDetail detail;

	

	@GetMapping("/moreForId")
	public String getListDetail(@RequestParam("id")int theId, Model theModel) {
		
		
		StudentDetail detail = iService.findById(theId).get().getStudentDetail();
		
		
		theModel.addAttribute("detail", detail);
		
		return "details";
	}

	
	@GetMapping("/students")
	public String showListEmployees(Model theModel) {
		
		List<Student> students = iService.findAll();
		
		theModel.addAttribute("students", students);
		
		return "student/list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String addNewStudent(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "student/add-form";
	}
	
	@PostMapping("/save")
	public String savenewStudent(Model theModel, @ModelAttribute("student") Student theStudent) {
		
		iService.save(theStudent);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateForm(@RequestParam("studentId") int theId, Model theModel) {
		
		Optional<Student> student = iService.findById(theId);
		
		theModel.addAttribute("student", student);
		
		return "student/add-form";
	}
	
	@GetMapping("/delete")
	public String deleteUserById(@RequestParam("studentId")int theId) {
		
		iService.deleteById(theId);
		return "redirect:/";
		
	}

	

}
