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
	private IServiceDetail IServiceDetail;
	

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
	
	
	// add several methods for detail about student
	
	@GetMapping("/moreForId")
	public String getListDetail(@RequestParam("id")int theId, Model theModel) {
		
		StudentDetail theStudentDetail = iService.findById(theId).get().getStudentDetail();
		
		
		theModel.addAttribute("detail", theStudentDetail);
		
		return "detailsStudent/details";
	}
	
	// show form for update StudentDetail
	
	@GetMapping("/updateDetail")
	public String updateDetail(@RequestParam("id")int theId, Model theModel) {
		StudentDetail studentDetail = IServiceDetail.findById(theId).get();
		
		theModel.addAttribute("studentDetail", studentDetail);
		return "detailsStudent/form-detail";
	}
	
	// update and return page for current student detail
	
	@PostMapping("/details/save")
	public String saveUpdate(@ModelAttribute("studentDetail")StudentDetail theStudentDetail) {
		
		StudentDetail detail = IServiceDetail.findById(theStudentDetail.getId()).get();
		int theId = detail.getStudent().getId();
		
		IServiceDetail.save(theStudentDetail);
	
		return "redirect:/api/moreForId?id=" + theId;
	}
	
	
	// if student detait not set , create new and add 
	
	@GetMapping("/createNewStudentDetailObject")
	public String createNewDetailObject(Model theModel, @RequestParam("id")int theId) {
		
		StudentDetail studentDetail = new StudentDetail();
		
		theModel.addAttribute("theStudentDetail", studentDetail);
		
		
		return "detailsStudent/createNewStudentDetail";
	}
	
	@PostMapping("/detail/save")
	public String createAndSetNewStudentDetailObject(@ModelAttribute("theStudentDetail")
				StudentDetail theStudentDetail) {
		
		
		
		return "redirect:/api/moreForId?id=";
	}
	

	

}
