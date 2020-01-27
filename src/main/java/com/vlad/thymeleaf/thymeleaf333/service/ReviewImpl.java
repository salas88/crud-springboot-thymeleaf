package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlad.thymeleaf.thymeleaf333.daojpa.ReviewDao;
import com.vlad.thymeleaf.thymeleaf333.entity.Review;

@Service
public class ReviewImpl implements IReview {
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		return reviewDao.findAll();
	}

	@Override
	public Optional<Review> findById(int theId) {
		// TODO Auto-generated method stub
		return reviewDao.findById(theId);
	}

	@Override
	public void save(Review review) {
		reviewDao.save(review);
		
	}

	@Override
	public void deleteById(int theId) {
		reviewDao.deleteById(theId);
		
	}


}
