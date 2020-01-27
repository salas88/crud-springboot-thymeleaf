package com.vlad.thymeleaf.thymeleaf333.service;

import java.util.List;
import java.util.Optional;

import com.vlad.thymeleaf.thymeleaf333.entity.Review;

public interface IReview {
	
	List<Review> findAll();
	Optional<Review> findById(int theId);
	void save(Review review);
	void deleteById(int theId);

}
