package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import com.vlad.thymeleaf.thymeleaf333.entity.Student;
import com.vlad.thymeleaf.thymeleaf333.entity.StudentDetail;

public interface IServiceDetail {
	
	List<StudentDetail> findAll();
	Optional<StudentDetail> findById(int theId);
	void save(StudentDetail theStudentDetail);
	void deleteById(int theId);

}
