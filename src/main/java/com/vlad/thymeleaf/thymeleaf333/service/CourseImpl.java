package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlad.thymeleaf.thymeleaf333.daojpa.CourseDao;
import com.vlad.thymeleaf.thymeleaf333.entity.Course;

@Service
public class CourseImpl implements ICourse{
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Optional<Course> findById(int theId) {
		// TODO Auto-generated method stub
		return courseDao.findById(theId);
	}

	@Override
	public void save(Course course) {
		courseDao.save(course);
		
	}

	@Override
	public void deleteById(int theId) {
		courseDao.deleteById(theId);
		
	}

}
