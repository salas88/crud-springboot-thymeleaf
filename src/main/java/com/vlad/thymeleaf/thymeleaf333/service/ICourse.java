package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import com.vlad.thymeleaf.thymeleaf333.entity.Course;

public interface ICourse {
	
	List<Course> findAll();
	Optional<Course> findById(int theId);
	void save(Course course);
	void deleteById(int theId);

}
