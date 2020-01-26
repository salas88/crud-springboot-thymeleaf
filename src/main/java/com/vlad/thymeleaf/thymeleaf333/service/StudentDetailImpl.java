package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlad.thymeleaf.thymeleaf333.daojpa.DetailDao;
import com.vlad.thymeleaf.thymeleaf333.entity.StudentDetail;

@Service
public class StudentDetailImpl implements IServiceDetail{
	
	private DetailDao detailDao;
	
	@Autowired
	public StudentDetailImpl(DetailDao theDetailDao) {
		detailDao = theDetailDao;
	}

	@Override
	public List<StudentDetail> findAll() {
		// TODO Auto-generated method stub
		return detailDao.findAll();
	}

	@Override
	public Optional<StudentDetail> findById(int theId) {
		// TODO Auto-generated method stub
		return detailDao.findById(theId);
	}

	@Override
	public void save(StudentDetail theStudentDetail) {
		detailDao.save(theStudentDetail);
		
	}

	@Override
	public void deleteById(int theId) {
		detailDao.deleteById(theId);
		
	}

}
