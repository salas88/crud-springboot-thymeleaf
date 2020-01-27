package com.vlad.thymeleaf.thymeleaf333.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vlad.thymeleaf.thymeleaf333.entity.Course;
import com.vlad.thymeleaf.thymeleaf333.entity.Review;
import com.vlad.thymeleaf.thymeleaf333.service.ICourse;
import com.vlad.thymeleaf.thymeleaf333.service.IReview;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private ICourse courseRepo;
	
	@Autowired
	private IReview reviewRepo;

	
	@GetMapping("/lists")
	public String getListCourse(Model theModel) {
	
		List<Course> courses = courseRepo.findAll();
		
		theModel.addAttribute("courses", courses);
		
		return "courses/list-courses";
		
	}
	
	@GetMapping("/reviewForId")
	public String getListReviewForCourse(@RequestParam("courseId")int theId, 
												Model theModel) {
		
		List<Review> reviews = courseRepo.findById(theId).get().getReviews();
		
		theModel.addAttribute("reviews", reviews);
		
		return "reviews/list-reviews";
		
	}

}
