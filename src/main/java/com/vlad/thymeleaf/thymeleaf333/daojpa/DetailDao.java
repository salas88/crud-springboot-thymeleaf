package com.vlad.thymeleaf.thymeleaf333.daojpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlad.thymeleaf.thymeleaf333.entity.StudentDetail;

public interface DetailDao extends JpaRepository<StudentDetail, Integer>{

}
