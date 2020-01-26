package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlad.thymeleaf.thymeleaf333.daojpa.JpaDao;
import com.vlad.thymeleaf.thymeleaf333.entity.Student;

@Service
public class ServiceImpl implements IService {
	
	private JpaDao jpaDao;
	
	@Autowired
	public ServiceImpl(JpaDao theJpaDao) {
		jpaDao = theJpaDao;
	}

	@Override
	public List<Student> findAll() {
		
		return jpaDao.findAll();
	}

	@Override
	public Optional<Student> findById(int theId) {
		// TODO Auto-generated method stub
		return jpaDao.findById(theId);
	}

	@Override
	public void save(Student theStudent) {
		jpaDao.save(theStudent);

	}

	@Override
	public void deleteById(int theId) {
		jpaDao.deleteById(theId);
		
	}

}
