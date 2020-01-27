package com.vlad.thymeleaf.thymeleaf333.daojpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlad.thymeleaf.thymeleaf333.entity.Review;

public interface ReviewDao extends JpaRepository<Review, Integer>{

}
