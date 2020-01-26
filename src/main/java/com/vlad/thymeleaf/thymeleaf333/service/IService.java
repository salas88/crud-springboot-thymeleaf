package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import com.vlad.thymeleaf.thymeleaf333.entity.Student;

public interface IService {
	
	List<Student> findAll();
	Optional<Student> findById(int theId);
	void save(Student theStudent);
	void deleteById(int theId);

}
